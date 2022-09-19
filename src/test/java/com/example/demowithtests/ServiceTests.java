package com.example.demowithtests;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.repository.Repository;
import com.example.demowithtests.service.Service;
import com.example.demowithtests.service.ServiceBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTests {

    @Mock
    private Repository repository;

    @InjectMocks
    private ServiceBean service;

    @Test
    public void whenSaveEmployee_shouldReturnEmployee() {
        Employee employee = new Employee();
        employee.setName("Mark");

        when(repository.save(ArgumentMatchers.any(Employee.class))).thenReturn(employee);

        Employee created = service.create(employee);

        assertThat(created.getName()).isSameAs(employee.getName());
        verify(repository).save(employee);
    }

    @Test
    public void whenGivenId_shouldReturnEmployee_ifFound() {
        Employee employee = new Employee();
        employee.setId(88);

        when(repository.findById(employee.getId())).thenReturn(Optional.of(employee));

        Employee expected = service.getById(employee.getId());

        assertThat(expected).isSameAs(employee);
        verify(repository).findById(employee.getId());
    }

    @Test(expected = EntityNotFoundException.class)
    public void should_throw_exception_when_employee_doesnt_exist() {
        Employee employee = new Employee();
        employee.setId(89);
        employee.setName("Mark");

        given(repository.findById(anyInt())).willReturn(Optional.empty());
        service.getById(employee.getId());
    }

    @Test
    public void whenGivenName_shouldReturnListEmployee() {

        Employee user = Employee.builder().name("Bob").build();

        List<Employee> employee = new ArrayList<>();
        employee.add(user);

        when(repository.getEmployeeByName(user.getName())).thenReturn(employee);

        List<Employee> expected = service.getName(user.getName());

        assertThat(expected.get(0).getName()).isEqualTo("Bob");
        assertThat(expected).isSameAs(employee);

        verify(repository).getEmployeeByName(user.getName());
    }

    @Test
    public void whenGivenCountry_shouldReturnListEmployee() {

        Employee user = new Employee();
        user.setCountry("usa");

        List<Employee> employee = new ArrayList<>();
        employee.add(user);

        when(repository.getEmployeeByCountry(user.getCountry())).thenReturn(employee);

        List<Employee> expected = service.getCountry(user.getCountry());

        assertThat(expected.get(0).getCountry()).isEqualTo("usa");
        assertThat(expected.size()).isGreaterThan(0);
        assertThat(expected).isSameAs(employee);

        verify(repository).getEmployeeByCountry(user.getCountry());
    }

    @Test
    public void whenGivenPhone_shouldReturnListEmployee() {

        Employee user = new Employee();
        user.setPhone(123456);

        List<Employee> employee = new ArrayList<>();
        employee.add(user);

        when(repository.getEmployeeByPhone(user.getPhone())).thenReturn(employee);

        List<Employee> expected = service.getNameByPhone(user.getPhone());

        assertThat(expected.get(0).getPhone()).isEqualTo(123456);
        assertThat(expected.size()).isGreaterThan(0);
        assertThat(expected).isSameAs(employee);

        verify(repository).getEmployeeByPhone(user.getPhone());
    }

    @Test
    public void whenEmployeeGetAllName_shouldReturnAllEmployeeThisName() {

        Employee user = Employee.builder().name("Viktor").build();

        List<Employee> employee = new ArrayList<>();
        employee.add(user);

        when(repository.getAllByName(user.getName())).thenReturn(employee);

        List<Employee> expected = service.getAllName(user.getName());

        assertThat(expected.get(0).getName()).isEqualTo("Viktor");
        assertThat(expected).isSameAs(employee);

        verify(repository).getAllByName(user.getName());
    }


}
