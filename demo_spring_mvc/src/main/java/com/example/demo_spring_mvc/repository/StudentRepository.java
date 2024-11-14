package com.example.demo_spring_mvc.repository;

import com.example.demo_spring_mvc.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"Minh",true,new String[]{"Java", "SQL"},1));
        studentList.add(new Student(2,"Lưu",true,new String[]{"Java","PHP","Javascript"},1));
        studentList.add(new Student(3,"Hưng",true,new String[]{"Java","React"},1));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public Student findById(int id) {
        for (int i = 0; i <studentList.size() ; i++) {
            if (id==studentList.get(i).getId()){
                return  studentList.get(i);
            }
        }
        return null;
    }
}
