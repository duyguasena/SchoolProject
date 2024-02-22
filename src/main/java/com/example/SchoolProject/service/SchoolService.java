package com.example.SchoolProject.service;

import com.example.SchoolProject.converter.SchoolConverter;
import com.example.SchoolProject.dto.request.SchoolRequest;
import com.example.SchoolProject.dto.response.SchoolCreateResponse;
import com.example.SchoolProject.exception.SchoolAlreadyExistException;
import com.example.SchoolProject.model.School;
import com.example.SchoolProject.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private  final SchoolRepository schoolRepository;

    public SchoolCreateResponse createSchool(SchoolRequest request) {
        Optional<School> schoolByName=schoolRepository.findBySchoolName(request.getSchoolName());
        if (schoolByName.isPresent()){
            throw  new SchoolAlreadyExistException("School name alredy exist with name:"+
                    request.getSchoolName());
        }
        return SchoolConverter.convertToSchoolCreateResponse(schoolRepository.save(SchoolConverter.convertToSchool(request)));
    }
}
