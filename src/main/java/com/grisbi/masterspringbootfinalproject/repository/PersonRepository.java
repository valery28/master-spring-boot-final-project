package com.grisbi.masterspringbootfinalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByDocumentNumber(String documentNumber);
}
