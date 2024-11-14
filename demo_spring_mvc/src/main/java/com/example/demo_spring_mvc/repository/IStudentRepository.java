package com.example.demo_spring_mvc.repository;

import com.example.demo_spring_mvc.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void save(Student student);
    Student findById(int id);
}
