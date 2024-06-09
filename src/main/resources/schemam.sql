CREATE TABLE Email_template (
    language_id INT NOT NULL,
    text CLOB,
    PRIMARY KEY (language_id)
);

CREATE TABLE Person (
    person_id INT NOT NULL,
    name VARCHAR(128) NOT NULL,
    date_of_birth DATE NOT NULL,
    country VARCHAR(128) NOT NULL,
    language_id INT NOT NULL,
    PRIMARY KEY (person_id),
    FOREIGN KEY (language_id) REFERENCES Email_template(language_id)
);

CREATE TABLE Car (
    car_id INT NOT NULL,
    brand VARCHAR(32),
    type VARCHAR(32),
    plate_number VARCHAR(16) NOT NULL,
    year_of_manufacture INT NOT NULL,
    calculated_value INT NOT NULL,
    driven_distance INT,
    is_sent BOOLEAN NOT NULL,
    PRIMARY KEY (car_id)
);

CREATE TABLE Car_of_person (
    person_id INT NOT NULL,
    car_id INT NOT NULL,
    PRIMARY KEY (person_id, car_id),
    FOREIGN KEY (person_id) REFERENCES Person(person_id),
    FOREIGN KEY (car_id) REFERENCES Car(car_id)
);