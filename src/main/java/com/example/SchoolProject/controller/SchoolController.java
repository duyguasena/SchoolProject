package com.example.SchoolProject.controller;

import com.example.SchoolProject.dto.request.SchoolRequest;
import com.example.SchoolProject.dto.response.SchoolResponse;
import com.example.SchoolProject.exception.SchoolAlreadyExistException;
import com.example.SchoolProject.exception.SchoolNotFoundException;
import com.example.SchoolProject.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    public SchoolResponse createSchool(@RequestBody SchoolRequest request){
        return schoolService.createSchool(request);
    }

    @DeleteMapping("{id}")
    public void deleteSchool(@PathVariable Long id){
        schoolService.deleteSchool(id);
    }

    @GetMapping("{id}")
    public SchoolResponse getSchoolById(@PathVariable Long id){
        return schoolService.getSchoolById(id);
    }

    @PutMapping("{id}")
    public void updateSchool(@PathVariable Long id,@RequestBody SchoolRequest request){
         schoolService.updateSchool(id,request);
    }

    //Bu buraya yazılmamalı geçici olarak burada dursun

    @ExceptionHandler(SchoolAlreadyExistException.class)
    public ResponseEntity<String> handleSchoolAlreadyExistException(SchoolAlreadyExistException e){
        return  new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(SchoolNotFoundException.class)
    public ResponseEntity<String> handleSchoolNotFoundException(SchoolNotFoundException e){
        return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
