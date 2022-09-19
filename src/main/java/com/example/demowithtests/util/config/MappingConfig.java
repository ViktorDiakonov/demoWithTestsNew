package com.example.demowithtests.util.config;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.EmployeeSaveDto;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

public class MappingConfig implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {

        mapperFactory.classMap(Employee.class, EmployeeSaveDto.class)
                .customize(new EmployeeMapper())
                .byDefault()
                .register();

        mapperFactory.classMap(Employee.class, EmployeeSaveDto.class)
                .byDefault()
                .register();
    }
}