package com.example.demo.api;

import com.example.demo.service.PersonService;
import com.example.demo.model.Person;

public class PersonController {
    
    private final PersonService personServie;

    public PersonController(PersonService personService){
        this.personServie = personService;
    }

    public void addPerson(Person person){
        personServie.addPerson(person);
    }
    
}