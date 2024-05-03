package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data //getter and setter
public class StudentDTO {
    private int id; //Auto generate
    private String name;
    private String address;
    private int age;
}
