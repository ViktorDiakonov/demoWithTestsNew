package com.example.demowithtests.util.config;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.*;
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

    public EmployeeSaveDto toSaveDto(Employee entity) {
        return mapperFacade.map(entity, EmployeeSaveDto.class);
    }
    public EmployeeSave2Dto toSave2Dto(Employee entity) {
        return mapperFacade.map(entity, EmployeeSave2Dto.class);
    }

    public EmployeeReadDto toReadDto(Employee entity) {
        return mapperFacade.map(entity, EmployeeReadDto.class);
    }
    public EmployeeRead2Dto toRead2Dto(Employee entity) {
        return mapperFacade.map(entity, EmployeeRead2Dto.class);
    }

    public EmployeeUpdateDto toUpdateDto(Employee entity) {
        return mapperFacade.map(entity, EmployeeUpdateDto.class);
    }

    public EmployeeUpdate2Dto toUpdate2Dto(Employee entity) {
        return mapperFacade.map(entity, EmployeeUpdate2Dto.class);
    }

    public Employee fromSaveDto(EmployeeSaveDto dto) {
        return mapperFacade.map(dto, Employee.class);
    }
}