package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.dto.EmployeeDTO;
import com.example.demo.model.dto.EmployeeFindIdDTO;
import com.example.demo.model.dto.EmployeeListDTO;
import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("admin/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AccountService accountService;

    @GetMapping("")
    public ResponseEntity<Page<EmployeeListDTO>> listEmployee(
            @PageableDefault(size = 8) Pageable pageable,
            @RequestParam(defaultValue = "") String searchName,
            @RequestParam(defaultValue = "") String searchId) {
        Page<EmployeeListDTO> employees;
        if (!searchName.equals("") || !searchId.equals("")) {
            return new ResponseEntity<Page<EmployeeListDTO>>(employeeService.findAllEmployeeByNameAndId
                    ("%" + searchName + "%", "%" + searchId + "%", pageable),(HttpStatus.OK));
        } else{
            employees = employeeService.findAllEmployee(pageable);
            System.out.println("finish query from db");
        }

        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAllAccount() {
        List<Account> accountList = accountService.getAllAccount();
        if (accountList.isEmpty()) {
            return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
    }

    @GetMapping("/createId")
    public ResponseEntity<Integer> getEmployeeId() {
        int employeeId = employeeService.getNextId();
        return new ResponseEntity<>(employeeId, HttpStatus.OK);
    }

    @PostMapping(value ="/create", consumes ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        Employee employee = new Employee();

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Map<String, String> listErrors = new HashMap<>();

        if(accountService.findAccountByAccountName(employeeDTO.getAccountName())!=null){
            listErrors.put("employeeError", "Tên tài khoản đã tồn tại.");
        }

        if (!listErrors.isEmpty()) {
            System.out.println(listErrors.keySet());
//            return ResponseEntity.badRequest().body(listErrors);
            return new ResponseEntity<>(listErrors, HttpStatus.NOT_MODIFIED);
        } else {
            employeeService.createNewEmployee(employeeDTO);
            employeeService.updateAutoRender();
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<EmployeeFindIdDTO> findEmployeeByIdToDelete(@PathVariable String id) {
        Optional<EmployeeFindIdDTO> employeeOptional = employeeService.findEmployeeById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }

    @PatchMapping("/delete/{id}")
    public  ResponseEntity<Employee> deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<EmployeeFindIdDTO> findEmployeeById(@PathVariable String id) {
        Optional<EmployeeFindIdDTO> employeeOptional = employeeService.findEmployeeById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }

    @PatchMapping(value ="/update/{id}", consumes ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateEmployee(@PathVariable String id,
                                            @RequestBody EmployeeDTO employeeDTO,
                                            BindingResult bindingResult) {
        Optional<EmployeeFindIdDTO> employeeOptional = employeeService.findEmployeeById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        if (bindingResult.hasFieldErrors()){
//            return new ResponseEntity(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
//        }
        else {
            employeeDTO.setEmployeeId(employeeOptional.get().getEmployeeId());
            employeeService.editEmployee(employeeDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        return errors;
    }
}
