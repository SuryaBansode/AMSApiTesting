package com.example.apiTesting.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "app_user") // Specify a custom table name
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
}