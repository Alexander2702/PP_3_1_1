package com.example.pp_3_1_1.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "age")
    private int age;

    public User(int id, String first_Name, String last_Name, int age) {
        this.id = id;
        this.firstName = first_Name;
        this.lastName = last_Name;
        this.age = age;
    }

    public User() {

    }

}

