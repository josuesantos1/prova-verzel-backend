package com.verzel.backend.Database.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class UsersModel {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String name;
    private String email;
    private String password;
}
