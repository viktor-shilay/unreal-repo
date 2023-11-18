package com.shilay.elasticsearchservice.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(indexName = "employees")
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Employee {

    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private String username;

    @Field(type = FieldType.Text)
    private String firstname;

    @Field(type = FieldType.Text)
    private String lastname;

    @Field(type = FieldType.Date, format = DateFormat.date)
    private LocalDate birthDate;

    private Role role;
    private List<Car> cars = new ArrayList<>();

    public enum Role {
        JAVA_DEV, PM, UNEMPLOYED
    }
}
