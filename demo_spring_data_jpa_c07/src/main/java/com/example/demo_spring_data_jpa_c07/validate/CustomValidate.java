package com.example.demo_spring_data_jpa_c07.validate;

import com.example.demo_spring_data_jpa_c07.dto.StudentDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDto studentDto = (StudentDto) target;
        if ("".equals(studentDto.getName())){
            errors.rejectValue("name", null, "Not Empty");
        }else if (!studentDto.getName().matches("^[A-Z][a-z]*(\\s[A-Z][a-z]+)+$")){
            errors.rejectValue("name", null, "Not Match");
        }
    }
}
