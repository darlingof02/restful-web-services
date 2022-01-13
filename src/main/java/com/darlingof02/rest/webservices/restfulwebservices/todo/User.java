package com.darlingof02.rest.webservices.restfulwebservices.todo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private long uid;
    private String username;
    private String password;


    public User() {

    }
}
