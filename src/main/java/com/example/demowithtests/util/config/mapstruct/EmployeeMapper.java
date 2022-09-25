package com.example.demowithtests.util.config.mapstruct;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeReadDto employeeReadDto(Employee employee);
    Employee employeeReadDtoToEmployee(EmployeeReadDto employeeReadDto);

    EmployeeSaveDto employeeSaveDto(Employee employee);
    Employee employeeRead2Dto(EmployeeSaveDto employeeCreateDto);

    EmployeeUpdateDto employeeUpdateDto(Employee employee);
    Employee employeeUpdateDtoToEmployee(EmployeeUpdateDto employeeUpdateDto);
}