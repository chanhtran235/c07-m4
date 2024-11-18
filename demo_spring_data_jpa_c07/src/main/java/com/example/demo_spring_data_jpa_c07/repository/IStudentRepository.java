package com.example.demo_spring_data_jpa_c07.repository;

import com.example.demo_spring_data_jpa_c07.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student ,Integer> {
  // tìm kiếm thì sao sao?
    List<Student> findStudentByNameContaining(String name);
    Page<Student> findStudentByNameContaining(String name, Pageable pageable);
    @Query(value = "select * from student where student.name like :name", nativeQuery = true)
    List<Student> searchByName(@Param("name") String name);

}
