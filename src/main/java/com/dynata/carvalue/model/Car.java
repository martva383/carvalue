package com.dynata.carvalue.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int carId;
    private String brand;
    private String type;
    private String plateNumber;
    private int yearOfManufacture;
    private int calculatedValue;
    private int drivenDistance;
    private boolean isSent;


}
