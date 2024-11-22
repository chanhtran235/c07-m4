package com.example.demo_spring_data_jpa_c07.service;

import com.example.demo_spring_data_jpa_c07.exception.AdminException;
import com.example.demo_spring_data_jpa_c07.model.Student;
import com.example.demo_spring_data_jpa_c07.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> seachByName(String searchName) {
        return studentRepository.searchByName("%"+searchName+"%");
    }

    @Override
    public Page<Student> searchByName(String name, Pageable pageable) {
        return studentRepository.findStudentByNameContaining(name,pageable);
    }

    @Override
    public void save(Student student){

        studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}
