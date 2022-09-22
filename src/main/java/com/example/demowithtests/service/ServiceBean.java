package com.example.demowithtests.service;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.repository.Repository;
import com.example.demowithtests.util.exeption.ResourceNotFoundException;
import com.example.demowithtests.util.exeption.ResourceWasDeletedException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
@Slf4j
@org.springframework.stereotype.Service
public class ServiceBean implements Service {

    private final Repository repository;

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        Employee employee = repository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceNotFoundException::new);
         /*if (employee.getIsDeleted()) {
            throw new EntityNotFoundException("Employee was deleted with id = " + id);
        }*/
        return employee;
    }

    @Override
    public Employee updateById(Integer id, Employee employee) {
        return repository.findById(id).map(entity -> {
                    entity.setName(employee.getName());
                    entity.setEmail(employee.getEmail());
                    entity.setCountry(employee.getCountry());
                    entity.setAddress(employee.getAddress());
                    entity.setPhone(employee.getPhone());
                    return repository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
    }

    @Override
    public void removeById(Integer id) {
        //repository.deleteById(id);
        Employee employee = repository.findById(id)
                // .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
                .orElseThrow(ResourceWasDeletedException::new);
        //employee.setIsDeleted(true);
        repository.delete(employee);
        //repository.save(employee);
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
    }

    public List<Employee> getName(String name) {
        return repository.getEmployeeByName(name);
    }

    @Override
    public List<Employee> getCountry(String country) {
        return repository.getEmployeeByCountry(country);
    }

    @Override
    public List<Employee> getAllName(String name) {
        return repository.getAllByName(name);
    }

    @Override
    public List<Employee> getNameByPhone(String phone) {
        return repository.getEmployeeByPhone(phone);
    }

    @Override
    public Employee updateByPhone(String phone, Employee employee) {
        return null;
    }

//    public Employee updateByPhone(String phone, Employee employee) {
//        return repository.getEmployeeByPhone(phone).map(entity -> {
//                    entity.setName(employee.getName());
//                    entity.setEmail(employee.getEmail());
//                    entity.setCountry(employee.getCountry());
//                    entity.setAddress(employee.getAddress());
//                    entity.setPhone(employee.getPhone());
//                    return repository.save(entity);
//                })
//                .orElseThrow(() -> new EntityNotFoundException("Employee not found with phone = " + phone));
//    }

    @Override
    public List<Employee> getEmployeeByPhoneU(String phone) {
        List<Employee> employees = repository.getEmployeeByPhoneU(phone);
        employees.stream().forEach(e -> System.err.println(e.getName() + " Доброго вечора,ми з Украины"));
        return employees;
    }
}
