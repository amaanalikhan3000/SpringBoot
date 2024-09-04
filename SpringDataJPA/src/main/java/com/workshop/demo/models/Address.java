package com.workshop.demo.models;



import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue


    private Integer id;
    private String streetName;
    private String houseNumber;

    private String ZipName;


    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
