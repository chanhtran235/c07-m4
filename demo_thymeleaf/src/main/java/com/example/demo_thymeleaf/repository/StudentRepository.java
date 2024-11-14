package com.example.demo_thymeleaf.repository;

import com.example.demo_thymeleaf.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepository implements IStudentRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
        return query.getResultList();
    }
    @Transactional
    @Override
    public void save(Student student) {
       entityManager.persist(student);
       // update =
        // + find => entityStudent
        // entityStudent.set(student.getId)
        ///
//       entityManager.merge(entityStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }
}
