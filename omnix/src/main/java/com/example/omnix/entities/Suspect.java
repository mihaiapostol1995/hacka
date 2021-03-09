package com.example.omnix.entities;

import lombok.Data;

import java.util.Set;

@Data
public class Suspect {
    private Long id;
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private Set<String> involvedIn; //cases?
}