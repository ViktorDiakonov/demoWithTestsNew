package com.example.demowithtests.repository;

import com.example.demowithtests.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
//@Component
public interface Repository extends JpaRepository<Employee, Integer> {

    Employee findByName(String name);

    @Query(value = "SELECT * FROM users WHERE name = ?", nativeQuery = true)
    List<Employee> getEmployeeByName(String name);

    @Query(value = "SELECT * FROM users WHERE country = ?", nativeQuery = true)
    List<Employee> getEmployeeByCountry(String country);

}
