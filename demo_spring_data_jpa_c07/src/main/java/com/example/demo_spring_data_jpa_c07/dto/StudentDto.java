package com.example.demo_spring_data_jpa_c07.dto;

import com.example.demo_spring_data_jpa_c07.model.Classes;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Setter
@Getter
@NoArgsConstructor
public class StudentDto implements Validator {
    private int id;
    private boolean gender;
//    @NotEmpty(message = "not Empty")
//    @Pattern(regexp = "^[A-Z][a-z]*(\s[A-Z][a-z]+)+$",message = "Not match")
    private String name;
    private Classes classes;

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
