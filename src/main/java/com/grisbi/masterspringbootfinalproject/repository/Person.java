package com.grisbi.masterspringbootfinalproject.repository;


import com.grisbi.masterspringbootfinalproject.domain.StringPayload;
//import org.springframework.data.annotation.Id;
//import javax.persistence.*;
import java.util.UUID;

public class Person {
    private UUID id;
    private String documentNumber;
    private DocumentType documentType;
    private String name;
    private String username;
    private String password;

    public Person(UUID id, String password) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
