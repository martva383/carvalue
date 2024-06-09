package com.dynata.carvalue.controller;

import com.dynata.carvalue.model.Car;
import com.dynata.carvalue.model.CarOfPerson;
import com.dynata.carvalue.model.Person;
import com.dynata.carvalue.repository.CarOfPersonRepository;
import com.dynata.carvalue.repository.CarRepository;
import com.dynata.carvalue.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarOfPersonRepository carOfPersonRepository;

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPersonById(@PathVariable int personId) {
        return personRepository.findById(personId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{personId}/cars")
    public ResponseEntity<List<Car>> getCarsByPersonId(@PathVariable int personId) {
        List<CarOfPerson> carOfPersons = carOfPersonRepository.findByPersonId(personId);
        List<Car> cars = carOfPersons.stream()
                .map(cop -> carRepository.findById(cop.getCarId()).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return ResponseEntity.ok(cars);
    }
}

