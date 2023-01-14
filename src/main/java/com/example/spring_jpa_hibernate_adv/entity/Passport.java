package com.example.spring_jpa_hibernate_adv.entity;

import jakarta.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false) // other properties on Column class!!! and we can set these values.
    private String number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport") // student is owning size, passport is non-owning side
    private Student student;

    public Passport(String number) {
        this.number = number;
    }

    protected Passport() {
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String name) {
        this.number = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
