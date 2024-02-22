package com.example.SchoolProject.converter;

import com.example.SchoolProject.dto.request.SchoolRequest;
import com.example.SchoolProject.dto.response.SchoolResponse;
import com.example.SchoolProject.model.School;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SchoolConverter {
    public static School convertToSchool(SchoolRequest request){
        School school=new School();
        school.setSchoolName(request.getSchoolName());
        return school;
    }

    public static SchoolResponse convertToSchoolResponse(School school){
        SchoolResponse schoolResponse =new SchoolResponse();
        schoolResponse.setCreatedDate(school.getCreatedDate());
        schoolResponse.setSchoolName(school.getSchoolName());
        return schoolResponse;
    }
}
