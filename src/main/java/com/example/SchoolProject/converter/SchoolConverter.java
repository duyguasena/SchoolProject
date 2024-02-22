package com.example.SchoolProject.converter;

import com.example.SchoolProject.dto.request.SchoolRequest;
import com.example.SchoolProject.dto.response.SchoolCreateResponse;
import com.example.SchoolProject.model.School;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SchoolConverter {
    public static School convertToSchool(SchoolRequest request){
        School school=new School();
        school.setSchoolName(request.getSchoolName());
        return school;
    }

    public static SchoolCreateResponse convertToSchoolCreateResponse(School school){
        SchoolCreateResponse schoolCreateResponse=new SchoolCreateResponse();
        schoolCreateResponse.setCreatedDate(school.getCreatedDate());
        schoolCreateResponse.setSchoolName(school.getSchoolName());
        return schoolCreateResponse;
    }
}
