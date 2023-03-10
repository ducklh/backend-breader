package com.example.demo.controller;

import com.example.demo.model.Cage;
import com.example.demo.model.Entities;
import com.example.demo.service.CageService;
import com.example.demo.service.EntitiesService;
import com.example.demo.service.impl.CageServiceImpl;
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

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RequestMapping("employee/entities")
public class EntitiesController {
    @Autowired
    private EntitiesService entitiesService;
    @Autowired
    private CageServiceImpl cageService;


    @GetMapping("/create")
    public ResponseEntity<?> getListCageId() {
        List<String> cageList = cageService.getListCageId();
        if (cageList.size()==0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(cageList,HttpStatus.OK);
        }

    }
    @GetMapping("/createId/{cageId}")
    public ResponseEntity<String> getEntitiesId(@PathVariable String cageId) {
        Integer currentId=entitiesService.getEntitiesId(cageId);
        String entitiesId=currentId.toString();
        Integer entitiesInCage=cageService.getEntitiesInCage(cageId);
        Integer quantity=cageService.findCageById(cageId).get().getQuantity();

        if(quantity>entitiesInCage){
            return new ResponseEntity<>(entitiesId,HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("")
    public ResponseEntity<Page<Entities>> findAllEntities(@PageableDefault(size = 10) Pageable pageable){
        Page<Entities> entities= entitiesService.findAll(pageable);
        if (entities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        return new ResponseEntity<>(entities,HttpStatus.OK);
        return new ResponseEntity<>(entities,HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Entities> findEntitiesById(@PathVariable String id) {
        Optional<Entities> entitiesOptional = entitiesService.findById(id);
        if (!entitiesOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(entitiesOptional.get(), HttpStatus.OK);
    }
    @PatchMapping("/delete/{id}")
    public  ResponseEntity<Entities> deleteEntities(@PathVariable String id){
        entitiesService.deleteEntities(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/update/{id}")
    public ResponseEntity<Entities> findEntitiesByIdToUpdate(@PathVariable String id) {
        Optional<Entities> entitiesOptional = entitiesService.findById(id);
        if (!entitiesOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(entitiesOptional.get(), HttpStatus.OK);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<?> createEntities(@Valid @RequestBody Entities entities, BindingResult bindingResult) throws Exception  {

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.NOT_MODIFIED);
        }
        else {
            entitiesService.updateAutoRender(entities.getCageId());
            entities.setDelete(false);

            entitiesService.save(entities);
            Cage cage = cageService.findCageById(entities.getCageId()).get();
            cageService.autoUpdateClosedDate(cage,entities);
            return new ResponseEntity<>(entities, HttpStatus.CREATED);
        }

    }


    @PatchMapping(value = "/update/{id}",consumes ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Entities> updateEntities(@PathVariable String id, @RequestBody Entities entities) {
        Optional<Entities> entitiesOptional = entitiesService.findById(id);
        if (!entitiesOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            entities.setDelete(false);
            entitiesService.save(entities);
            Cage cage = cageService.findCageById(entities.getCageId()).get();
        
            cageService.autoUpdateClosedDate(cage,entities);
            return new ResponseEntity<>(entities,HttpStatus.OK);
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

        System.out.println(errors.toString());
        return errors;
    }
    @GetMapping("/search")
    public ResponseEntity<Page<Entities>> findAllEntitiesByInDateAndCage(@PageableDefault(size = 10) Pageable pageable, @RequestParam(defaultValue = "0") Integer page,
                                                                         @RequestParam(defaultValue = "", name = "inDateMin") String inDateMin,
                                                                         @RequestParam(defaultValue = "", name = "inDateMax") String inDateMax,
                                                                         @RequestParam(defaultValue = "", name = "cage") String cage) {
        System.out.println("inDateMin" + inDateMin);
        System.out.println("cage " + cage);
//        inDate = "%" + inDate + "%";
//        cage = "%" + cage + "%";
        System.out.println("inDateMax" + inDateMax);
        System.out.println("cage " + cage);
        if (inDateMin.isEmpty()){
            inDateMin="2000-03-15";
        }
        if (inDateMax.isEmpty()){
            inDateMax="2025-03-13";
        }
        if(cage.isEmpty()){
            cage="%";
        }
        System.out.println("inDateMin" + inDateMin);
        System.out.println("cage " + cage);
//        inDate = "%" + inDate + "%";
//        cage = "%" + cage + "%";
        System.out.println("inDateMax" + inDateMax);
        System.out.println("cage " + cage);
        Page<Entities> entities = entitiesService.findAllByInDateAndCage3(pageable, inDateMin,inDateMax, cage);

        if (entities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}