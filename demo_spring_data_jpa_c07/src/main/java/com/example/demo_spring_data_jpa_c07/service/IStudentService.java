package com.example.demo_spring_data_jpa_c07.service;

import com.example.demo_spring_data_jpa_c07.exception.AdminException;
import com.example.demo_spring_data_jpa_c07.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    List<Student> seachByName(String searchName);
    Page<Student> searchByName(String name, Pageable pageable);
    void save(Student student)throws AdminException;
    Student findById(int id);

}
