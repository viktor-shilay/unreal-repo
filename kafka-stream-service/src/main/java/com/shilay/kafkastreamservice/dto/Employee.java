package com.shilay.kafkastreamservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Employee {

    private Long id;
    private String username;
    private String firstname;
    private String lastname;

    @JsonProperty("birth_date")
    private LocalDate birthDate;
    private Role role;

    public enum Role {
        JAVA_DEV, PM, UNEMPLOYED
    }
}
