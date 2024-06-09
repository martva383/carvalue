package com.dynata.carvalue.repository;

import com.dynata.carvalue.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
