package com.dynata.carvalue.service;

import com.dynata.carvalue.model.Car;
import com.dynata.carvalue.model.CarOfPerson;
import com.dynata.carvalue.model.EmailTemplate;
import com.dynata.carvalue.model.Person;
import com.dynata.carvalue.repository.CarOfPersonRepository;
import com.dynata.carvalue.repository.CarRepository;
import com.dynata.carvalue.repository.EmailTemplateRepository;
import com.dynata.carvalue.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailTemplateRepository emailTemplateRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarOfPersonRepository carOfPersonRepository;

    public String generateEmail(int personId) {
        Person person = personRepository.findById(personId).orElseThrow();
        EmailTemplate emailTemplate = emailTemplateRepository.findById(person.getLanguageId()).orElseThrow();
        List<CarOfPerson> carOfPersons = carOfPersonRepository.findByPersonId(personId);

        StringBuilder carDescriptions = new StringBuilder();
        String carTemplate = emailTemplate.getText().substring(
                emailTemplate.getText().indexOf("<CarLoopBegin>") + "<CarLoopBegin>".length(),
                emailTemplate.getText().indexOf("<CarLoopEnd>")
        );

        for (CarOfPerson cop : carOfPersons) {
            Car car = carRepository.findById(cop.getCarId()).orElseThrow();
            if (car.getCalculatedValue() > 0 && !car.isSent()) {
                String carDescription = carTemplate
                        .replace("<brand>", car.getBrand())
                        .replace("<type>", car.getType())
                        .replace("<plateNumber>", car.getPlateNumber())
                        .replace("<yearOfManufacture>", String.valueOf(car.getYearOfManufacture()))
                        .replace("<drivenDistance>", String.valueOf(car.getDrivenDistance()))
                        .replace("<calculatedValue>", String.valueOf(car.getCalculatedValue()));
                carDescriptions.append(carDescription);
            }
        }

        String emailText = emailTemplate.getText()
                .replace("<name>", person.getName())
                .replace("<country>", person.getCountry())
                .replace("<dateOfBirth>", person.getDateOfBirth().toString())
                .replace("<CarLoopBegin>", "")
                .replace("<CarLoopEnd>", carDescriptions.toString());

        return emailText;
    }
}


