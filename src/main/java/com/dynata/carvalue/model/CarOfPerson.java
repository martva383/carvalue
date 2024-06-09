package com.dynata.carvalue.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@IdClass(CarOfPersonId.class)
@Table(name = "Car_of_person")
public class CarOfPerson {
    @Id
    private int personId;
    @Id
    private int carId;

}
