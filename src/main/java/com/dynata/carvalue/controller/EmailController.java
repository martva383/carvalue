package com.dynata.carvalue.controller;

import com.dynata.carvalue.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/{personId}")
    public ResponseEntity<String> getEmail(@PathVariable int personId) {
        return ResponseEntity.ok(emailService.generateEmail(personId));
    }
}
