package com.example.spring_jpa_hibernate_adv.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class PartTimeEmployee extends Employee {


    private BigDecimal hourlyWag;

    public PartTimeEmployee(){}

    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWag = hourlyWage;
    }
}
