package com.grisbi.masterspringbootfinalproject.controller;

import com.grisbi.masterspringbootfinalproject.repository.DocumentType;
import com.grisbi.masterspringbootfinalproject.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentTypes")
public class DocumentTypeController {
    @Autowired
    private DocumentTypeService documentTypeService;

    @PostMapping("/saveDocumentType")
    public String saveDocumentType(@RequestBody DocumentType documentType) {
        documentTypeService.save(documentType);
        return "Document type saved successfully";
    }
    @GetMapping
    public List<DocumentType> getAllDocumentTypes() {
        return documentTypeService.findAll();
    }
}
