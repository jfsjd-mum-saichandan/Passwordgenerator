package com.submit.submit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.submit.submit.model.registrations;
import com.submit.submit.service.RegistrationService;

@RestController
public class registrationcontroller {
    @Autowired 
    private RegistrationService registrationservice;
    @CrossOrigin
    @PostMapping("/registrations")
    public ResponseEntity<String>createRegistration(@RequestBody registrations registration){
        String status = registrationservice.createregistration(registration);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping("/registrations/{id}")

    public ResponseEntity<registrations> getRegistrationById(@PathVariable Integer id){
        registrations status = registrationservice.getregistrationById(id);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping("/registrations")
    public ResponseEntity<Iterable<registrations>> getAllregistrations(){
        Iterable<registrations> status = registrationservice.getAllregistrations();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    @PutMapping("/registrations/{id}")
    public ResponseEntity<registrations> updateRegistration(@PathVariable Integer id,@RequestBody registrations registrations){
        registrations status = registrationservice.updateregistrationById(id,registrations);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
    @DeleteMapping("/registrations/{id}")
    public ResponseEntity<registrations> deleteStudentById(@PathVariable Integer id){
        registrations status = registrationservice.deleteregistrationById(id);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
}
