package com.example.demo.controller;
import com.example.demo.model.Cage;
import com.example.demo.model.Employee;
import com.example.demo.model.dto.CageCreateDto;
import com.example.demo.model.dto.CageEditDto;
import com.example.demo.model.dto.CageForEditDto;
import com.example.demo.model.dto.EmployeeForCageDto;
import com.example.demo.service.impl.CageServiceImpl;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;
import com.example.demo.model.dto.CageListDTO;
import com.example.demo.model.dto.GetEmployeeNameDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import java.util.List;

@RestController
@RequestMapping("employee/cage")
//@RequestMapping("api/public")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CageController {
    @Autowired
    private CageServiceImpl cageService;

    @Autowired
    private EmployeeServiceImpl employeeService;


    @GetMapping("/createId")
    public ResponseEntity<Integer> getCageIdForCreate() {
        int cageId = cageService.getNextId();
        return new ResponseEntity<>(cageId, HttpStatus.OK);
    }

    @GetMapping("/username/{user}")
    public ResponseEntity<?> getEmployeeIdForCreate(@PathVariable String user){
        EmployeeForCageDto employee = cageService.getEmployeeIdAndName(user);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCage(@Valid @RequestBody CageCreateDto cageCreateDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }
        System.out.println("cageCreateDTO: " + cageCreateDto.toString());

        Cage cage = new Cage();

        Map<String, String> listErrors = new HashMap<>();

        String employeeIdFromDto = cageCreateDto.getEmployeeId().trim();
        System.out.println("employeeId before substring: " + employeeIdFromDto);
        String employeeId = employeeIdFromDto.substring(0, employeeIdFromDto.indexOf("-")).trim();
        System.out.println("employeeId after substring: " + employeeId);

        System.out.println("Mã nhân viên tạo: " + employeeId);
        System.out.println("checkEmployee: " + !cageService.checkEmployee(employeeId));
        if (!cageService.checkEmployee(employeeId)) {
            System.out.println("tên employee không có ");
            listErrors.put("employeeError", "Tên nhân viên không tồn tại.");
        }

        BeanUtils.copyProperties(cageCreateDto, cage);

        if (cageService.existsByCageId(cage.getCageId())) {
            System.out.println("Tên chuồng nuôi đã tồn tại");
            listErrors.put("cageError", "Mã chuồng nuôi đã tồn tại.");
        }

        if (cage.getQuantity() < 1 || cage.getQuantity() > 50) {
            System.out.println("Sai gia tri quantity");
            listErrors.put("quantityError", "So luong ca the sai.");
        }

        if (!cageService.isValidDate(cage)){
            System.out.println("Lỗi ngày tạo và đóng chuồng.");
            listErrors.put("cageError", "Lỗi ngày tạo và đóng chuồng.");
        }

        Employee employee = employeeService.findEmpById(employeeId);
        if (employee != null) {
            cage.setEmployee(employee);
        } else {
            System.out.println("Lỗi tim thong tin nhan vien.");
            listErrors.put("employeeError", "Khong tim thay thong tin nhan vien.");
        }

        if (!listErrors.isEmpty()) {
            System.out.println(listErrors.keySet());
//            return ResponseEntity.badRequest().body(listErrors);
            return new ResponseEntity<>(listErrors, HttpStatus.NOT_MODIFIED);
        } else {
            System.out.println("cage to save: " + cage.toString());
            cageService.save(cage);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    // for edit
    @GetMapping("/listEmployee")
    public ResponseEntity<?> getListEmployeeForEdit(){
        List<EmployeeForCageDto> employeeList = employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    // ok
//    @GetMapping("/edit/{id}")
//    public ResponseEntity<?> findCageByIdForEdit(@PathVariable String id) {
//        Optional<Cage> cage = cageService.findCageById(id);
//        if (!cage.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(cage.get(), HttpStatus.OK);
//    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<?> findCageByIdForEdit(@PathVariable String id) {
        Optional<CageForEditDto> cage = cageService.findCageById2(id);
        System.out.println("cageID: " + id );
        if (!cage.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cage.get(), HttpStatus.OK);
    }



    @PatchMapping(value = "/edit/{id}")
    public ResponseEntity<?> updateCage(@RequestBody @Valid CageEditDto cageEditDto, BindingResult bindingResult, @PathVariable String id){


        //get cageID
        System.out.println("cageId in CageEditDto: " + cageEditDto.getCageId());
        Optional<Cage> cageOptional = cageService.findCageById(cageEditDto.getCageId());
        if (!cageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_ACCEPTABLE);
        }
        Cage cage = cageOptional.get();
        System.out.println("cage after find by id: "+cage.toString());
        Map<String, String> listErrors = new HashMap<>();

        String employeeIdFromDto = cageEditDto.getEmployeeId().trim();
        System.out.println("employeeId before substring: " + employeeIdFromDto);
        String employeeId = employeeIdFromDto.substring(0, employeeIdFromDto.indexOf("-")).trim();
        System.out.println("employeeId after substring: " + employeeId);

        if (!cageService.checkEmployee(employeeId)) {
            System.out.println("tên employee không có ");
            listErrors.put("employeeError", "Tên nhân viên không tồn tại.");
        }

        BeanUtils.copyProperties(cageEditDto, cage);

        if (!cageService.isValidDate(cage)){
            System.out.println("Lỗi ngày tạo và đóng chuồng.");
            listErrors.put("cageError", "Lỗi ngày tạo và đóng chuồng.");
        }

        Employee employee = employeeService.findEmpById(employeeId);
        cage.setEmployee(employee);

        System.out.println("listError: "+ !listErrors.isEmpty());
        if (!listErrors.isEmpty()) {
            System.out.println(listErrors.keySet());
//            return ResponseEntity.badRequest().body(listErrors);
            return new ResponseEntity<>(listErrors, HttpStatus.NOT_MODIFIED);
        } else {
            cageService.save(cage);
            return new ResponseEntity<>(cage, HttpStatus.OK);
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


    @GetMapping("/get_employee")
    public ResponseEntity<List<GetEmployeeNameDTO>> getAllEmployeeName(){
        List<GetEmployeeNameDTO> employeeList=cageService.getAllEmployeeName();
        if(employeeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(employeeList,HttpStatus.OK);
        }
    }
    @GetMapping("")
    public ResponseEntity<?> findAllCage(@PageableDefault(size = 2) Pageable pageable,
                                         @RequestParam(value = "sort",defaultValue = "") String sort,
                                         @RequestParam(value = "type",defaultValue = "") boolean type){
        Page<CageListDTO> cageListDTOPage=cageService.findAllCage(pageable);
        if(cageListDTOPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            if(type){
                cageListDTOPage=cageService.findAllCage(PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),Sort.by(sort).ascending()));

            }
            else {
                cageListDTOPage=cageService.findAllCage(PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),Sort.by(sort).descending()));

            }
            return new ResponseEntity<>(cageListDTOPage,HttpStatus.OK);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<?> findCage(@PageableDefault(size = 2) Pageable pageable,
                                      @RequestParam(value = "dateType", defaultValue = "") String dateType,
                                      @RequestParam(value = "dateFrom",defaultValue = "") String dateFrom,
                                      @RequestParam(value = "dateTo",defaultValue = "") String dateTo,
                                      @RequestParam(value = "employee",defaultValue = "") String employeeId,
                                      @RequestParam(value = "sort",defaultValue = "") String sort,
                                      @RequestParam(value = "type",defaultValue = "") boolean type,
                                      @RequestParam(value = "searchCageId",defaultValue = "") String searchCageId){
        Page<CageListDTO> cageListDTOPage;
        if(employeeId.isEmpty()){
            employeeId="%";
        }
        if(dateFrom.isEmpty()){
            dateFrom="2000-01-01";
        }
        if(dateTo.isEmpty()){
            dateTo="2200-12-30";
        }
        if(searchCageId.isEmpty()){
            searchCageId="%";
        }
        if(dateType.equals("createdDate")){
            if(type){
                cageListDTOPage=cageService.findCageByCreatedDate(searchCageId,employeeId,dateFrom,dateTo,PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),Sort.by(sort).ascending()));
            }
            else {
                cageListDTOPage=cageService.findCageByCreatedDate(searchCageId,employeeId,dateFrom,dateTo,PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),Sort.by(sort).descending()));
            }

        }
        else {
            if(type){
                cageListDTOPage=cageService.findCageByCloseDate(searchCageId,employeeId,dateFrom,dateTo,PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),Sort.by(sort).ascending()));
            }
            else {
                cageListDTOPage=cageService.findCageByCloseDate(searchCageId,employeeId,dateFrom,dateTo,PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),Sort.by(sort).descending()));
            }
        }
        if(cageListDTOPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(cageListDTOPage, HttpStatus.OK);
        }
    }

}