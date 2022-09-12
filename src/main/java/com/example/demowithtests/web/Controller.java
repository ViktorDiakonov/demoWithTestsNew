package com.example.demowithtests.web;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    private final Service service;

    //Операция сохранения юзера в базу данных
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return service.create(employee);
    }

    //Получение списка юзеров
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllUsers() {
        return service.getAll();
    }

    //Получения юзера по id
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable Integer id) {

        Employee employee = service.getById(id);
        return employee;
    }

    //Обновление юзера
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee refreshEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {

        return service.updateById(id, employee);
    }

    //Удаление по id
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable Integer id) {
        service.removeById(id);
    }

    //Удаление всех юзеров
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        service.removeAll();
    }

    // выводит всех пользователей с указанным именем
    @GetMapping(value = "/users", params = {"name"})
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getName(@RequestParam (value = "name") String name){
        return service.getName(name);
    }

    // выводит всех пользователей по указанной стране
    @GetMapping(value = "/users", params = {"country"})
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getCountry(@RequestParam (value = "country") String country){
        return service.getCountry(country);
    }

    // выводит всех пользователей из колонки "name"
    @GetMapping(value = "/users", params = {"allname"})
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllName(@RequestParam (value = "name") String name){
        return service.getAllName(name);
    }

    //получение пользователя по его номеру телефона
    @GetMapping(value = "/users", params = {"phone"})
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getNameByPhone(@RequestParam (value = "phone") Integer phone) {
        return service.getNameByPhone(phone);
    }

    //обновление пользователя по телефону
    @PutMapping("/users/{phone}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updatePhone(@PathVariable("phone") Integer phone, @RequestBody Employee employee) {

        return service.updateById(phone, employee);
    }
}
