package com.example.demo.api;

import com.example.demo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Person;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    
    private final PersonService personServie;

    @Autowired
    public PersonController(PersonService personService){
        this.personServie = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personServie.addPerson(person);
    }
    
    @GetMapping
    public List<Person> getAllPeople(){
        return personServie.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable ("id")UUID id){
        return personServie.getPersonById(id)
                .orElse(null);
    }
    @DeleteMapping
    public void deletePersonById(@PathVariable("id") UUID id){
        personServie.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){
        personServie.updatePerson(id, personToUpdate);
    }
}