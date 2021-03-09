package com.example.omnix.entities;

import lombok.Data;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Table(name = "EVENTS")
public class Event {
    Long id;
    @OneToMany
    Set<Suspect> suspects;
    Location location;
}
