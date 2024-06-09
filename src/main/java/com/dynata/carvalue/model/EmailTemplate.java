package com.dynata.carvalue.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Email_template")
public class EmailTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int languageId;
    @Column(name="text", columnDefinition="CLOB")
    private String text;


}
