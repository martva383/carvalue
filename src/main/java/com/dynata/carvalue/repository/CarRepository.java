package com.dynata.carvalue.repository;

import com.dynata.carvalue.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByCalculatedValueGreaterThanAndIsSentFalse(int value);
}
