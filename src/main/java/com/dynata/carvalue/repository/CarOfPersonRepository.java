package com.dynata.carvalue.repository;

import com.dynata.carvalue.model.CarOfPerson;
import com.dynata.carvalue.model.CarOfPersonId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarOfPersonRepository extends JpaRepository<CarOfPerson, CarOfPersonId> {
    List<CarOfPerson> findByPersonId(int personId);
}

