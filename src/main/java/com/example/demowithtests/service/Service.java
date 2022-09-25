package com.example.demowithtests.service;

import com.example.demowithtests.domain.Employee;

import java.util.List;

public interface Service {

    Employee create(Employee employee);

    List<Employee> getAll();

    Employee getById(Integer id);

    Employee updateById(Integer id, Employee employee);

    void removeById(Integer id);

    void removeAll();

    List<Employee> getName(String name);

    List<Employee> getCountry(String country);

    List<Employee> getAllName(String name);

    List<Employee> getNameByPhone(String phone);

    Employee updateByPhone(String phone, Employee employee);

    List<Employee>getEmployeeByPhoneU(String phone);

}