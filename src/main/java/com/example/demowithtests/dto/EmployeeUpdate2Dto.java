package com.example.demowithtests.dto;
import java.time.Instant;
import java.util.Date;

public class EmployeeUpdate2Dto {
//при переезде изменение страны и адреса

    public String address;
    public String country;

    //todo: dfhgjkdfhg Jira - 5544
    public Date date = Date.from(Instant.now());
}
