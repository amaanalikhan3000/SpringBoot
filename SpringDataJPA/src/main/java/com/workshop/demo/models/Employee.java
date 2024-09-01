package com.workshop.demo.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Column
            (
                    unique =  false,
                    nullable = false
            )

    @Id
    @GeneratedValue
    private Integer id;

    private String identifier;

    @Column(nullable = false)
    private String firstName;
    private String email;
    private LocalDate birthDate;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeRole role;


}
