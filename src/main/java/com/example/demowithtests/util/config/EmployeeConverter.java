package com.example.demowithtests.util.config;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.EmployeeSaveDto;
import com.example.demowithtests.dto.EmployeeReadDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    private final MapperFacade mapperFacade;

    public EmployeeConverter(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }

    public MapperFacade getMapperFacade() {
        return mapperFacade;
    }

    public EmployeeSaveDto toDto(Employee entity) {
        return mapperFacade.map(entity, EmployeeSaveDto.class);
    }

    public EmployeeReadDto toReadDto(Employee entity) {
        return mapperFacade.map(entity, EmployeeReadDto.class);
    }


    public Employee fromDto(EmployeeSaveDto dto) {
        return mapperFacade.map(dto, Employee.class);
    }
}