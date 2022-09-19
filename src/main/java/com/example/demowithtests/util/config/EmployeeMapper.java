package com.example.demowithtests.util.config;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.EmployeeSaveDto;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class EmployeeMapper extends CustomMapper<Employee, EmployeeSaveDto> {

    @Override
    public void mapBtoA(EmployeeSaveDto dto, Employee entity, MappingContext context) {
        super.mapBtoA(dto, entity, context);
    }
}