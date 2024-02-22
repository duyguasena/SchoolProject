package com.example.SchoolProject.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class SchoolCreateResponse {
    private  String schoolName;
    private Date createdDate;
}
