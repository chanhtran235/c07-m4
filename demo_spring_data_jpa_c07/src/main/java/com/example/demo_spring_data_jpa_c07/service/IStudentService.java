package com.example.demo_spring_data_jpa_c07.service;

import com.example.demo_spring_data_jpa_c07.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    List<Student> seachByName(String searchName);
    void save(Student student);
    Student findById(int id);

}
