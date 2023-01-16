package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import com.example.spring_jpa_hibernate_adv.entity.Employee;
import com.example.spring_jpa_hibernate_adv.entity.Review;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    // insert employee
    public void insert(Employee employee) {
        em.persist(employee);
    }

    // retrieve all employees
    public List<Employee> retrieveAllEmployees() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }




}
