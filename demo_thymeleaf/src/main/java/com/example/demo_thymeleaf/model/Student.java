package com.example.demo_thymeleaf.model;


import javax.persistence.*;

@Entity
//@Table(name = "sinh_vien")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean gender;

//    @Column(name = "ten",columnDefinition = "TEXT")
    private String name;
    private int classId;

    public Student() {
    }

    public Student(int id,  String name,boolean gender, int classId) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
