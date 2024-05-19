package com.grisbi.masterspringbootfinalproject.controller;

import com.grisbi.masterspringbootfinalproject.repository.Person;
import com.grisbi.masterspringbootfinalproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/createPerson")
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PutMapping("/update")
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

}
