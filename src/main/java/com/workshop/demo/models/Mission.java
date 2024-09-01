package com.workshop.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Mission {

    @GeneratedValue

    @Id

    private Integer id;
    private String  name;
    private int duration;


    @ManyToMany(mappedBy = "missions")
    private List<Employee>employees;
}
