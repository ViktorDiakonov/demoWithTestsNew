package com.example.demowithtests.repository;

import com.example.demowithtests.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
//@Component
public interface Repository extends JpaRepository<Employee, Integer> {

    Employee findByName(String name);

    // выводит всех пользователей с указанным именем
    @Query("SELECT e FROM Employee e WHERE e.name = ?1")
    List<Employee> getEmployeeByName(String name);

    // выводит всех пользователей по указанной стране
    @Query(value = "SELECT * FROM users WHERE country = ?", nativeQuery = true)
    List<Employee> getEmployeeByCountry(String country);

    // выводит всех пользователей из колонки "name"
    @Query(value = "SELECT name FROM users", nativeQuery = true)
    List<Employee> getAllByName(String name);

    //получение пользователя по его номеру телефона
    @Query("SELECT e FROM Employee e WHERE e.phone = ?1")
    List<Employee> getEmployeeByPhone (String phone);

    @Query(value = "SELECT * FROM Users WHERE phone like ?%", nativeQuery = true)
    List<Employee> getEmployeeByPhoneU(String phone);
}
