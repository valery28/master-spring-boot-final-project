package com.grisbi.masterspringbootfinalproject.service;

import com.grisbi.masterspringbootfinalproject.repository.Person;
import com.grisbi.masterspringbootfinalproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {
        Optional<Person> foundPerson = personRepository.findByDocumentNumber(person.getDocumentNumber());
        if (foundPerson.isPresent()) {
            throw new RuntimeException("Person already registered");
        }
        personRepository.save(person);
        return person;
    }

   public List<Person> findAll() {
        return personRepository.findAll();
    }
    public Person updatePerson(Person person) {
        Optional<Person> foundPerson = personRepository.findByDocumentNumber(person.getDocumentNumber());
        if (foundPerson.isPresent()) {
            foundPerson.get().setPassword(person.getPassword());
            foundPerson.get().setUsername(person.getUsername());
            personRepository.save(foundPerson.get());
            return foundPerson.get();
        } else {
            throw new RuntimeException("Person not found");
        }
    }
}

