package com.example.spring_jpa_hibernate_adv.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false) // other properties on Column class!!! and we can set these values.
    private String name;

    @OneToOne
    private Passport passport;

    public Student(String name) {
        this.name = name;
    }

    protected Student() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
