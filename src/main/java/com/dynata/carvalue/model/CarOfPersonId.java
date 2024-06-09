package com.dynata.carvalue.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class CarOfPersonId implements Serializable {
    private int personId;
    private int carId;


}
