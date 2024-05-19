package com.grisbi.masterspringbootfinalproject.service;

import com.grisbi.masterspringbootfinalproject.repository.DocumentType;
import com.grisbi.masterspringbootfinalproject.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeService {
    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public List<DocumentType> findAll() {
        return documentTypeRepository.findAll();
    }

    public void save(DocumentType documentType) {
        documentTypeRepository.save(documentType);
    }

}

