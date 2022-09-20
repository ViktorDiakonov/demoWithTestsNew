package com.example.demowithtests.dto;
import java.time.Instant;
import java.util.Date;

public class EmployeeUpdateDto {
//при переезде изменение адреса и имейла

    public String phone;
    public String email;

    //todo: dfhgjkdfhg Jira - 5544
    public Date date = Date.from(Instant.now());
}
