package com.shilay.kafkastreamservice.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Employee {

    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private Role role;

    public enum Role {
        JAVA_DEV, PM, UNEMPLOYED
    }
}
