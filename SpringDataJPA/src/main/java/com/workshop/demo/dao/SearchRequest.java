package com.workshop.demo.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest {
    private String firstName;
    private String lastName;
    private String email;
}
