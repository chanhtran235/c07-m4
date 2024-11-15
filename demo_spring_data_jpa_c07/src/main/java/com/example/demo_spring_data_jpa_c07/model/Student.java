package com.example.demo_spring_data_jpa_c07.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean gender;
    private String name;
    @OneToOne
    @JoinColumn(unique = true)
    private Jame jame;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Classes classes;

}
