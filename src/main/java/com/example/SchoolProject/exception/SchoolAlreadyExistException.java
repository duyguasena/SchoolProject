package com.example.SchoolProject.exception;

public class SchoolAlreadyExistException extends RuntimeException{
    public SchoolAlreadyExistException(String message) {
        super(message);
    }
}
