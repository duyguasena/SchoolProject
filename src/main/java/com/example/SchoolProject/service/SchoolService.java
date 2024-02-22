package com.example.SchoolProject.service;

import com.example.SchoolProject.converter.SchoolConverter;
import com.example.SchoolProject.dto.request.SchoolRequest;
import com.example.SchoolProject.dto.response.SchoolResponse;
import com.example.SchoolProject.exception.SchoolAlreadyExistException;
import com.example.SchoolProject.exception.SchoolNotFoundException;
import com.example.SchoolProject.model.School;
import com.example.SchoolProject.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private  final SchoolRepository schoolRepository;

    public SchoolResponse createSchool(SchoolRequest request) {
        Optional<School> schoolByName=schoolRepository.findBySchoolName(request.getSchoolName());
        if (schoolByName.isPresent()){
            throw  new SchoolAlreadyExistException("School name alredy exist with name:"+
                    request.getSchoolName());
        }
        return SchoolConverter.convertToSchoolResponse(schoolRepository.save(SchoolConverter.convertToSchool(request)));
    }

    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

    public SchoolResponse getSchoolById(Long id) {
        return SchoolConverter.convertToSchoolResponse(findById(id));
    }

    public School findById(Long id){
        return schoolRepository.findById(id)
                .orElseThrow(()->new SchoolNotFoundException("School not found!!"+id));
    }

    public void updateSchool(Long id, SchoolRequest request) {
        School oldSchool=findById(id);
        oldSchool.setSchoolName(request.getSchoolName());
        schoolRepository.save(oldSchool);
    }
}
