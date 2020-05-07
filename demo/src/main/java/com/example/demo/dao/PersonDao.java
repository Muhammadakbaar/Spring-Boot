package com.example.demo.dao;

import com.example.demo.model.Person;
import java.util.UUID;

public interface PersonDao {

    int insetPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insetPerson(id, person);
    }
    
}