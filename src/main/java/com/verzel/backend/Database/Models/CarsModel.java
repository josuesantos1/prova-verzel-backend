package com.verzel.backend.Database.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cars")
public class CarsModel {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String owner;
    private String name;
    private String brand;
    private String model;
    private String description;
    private String photo;
    private String price;
}
