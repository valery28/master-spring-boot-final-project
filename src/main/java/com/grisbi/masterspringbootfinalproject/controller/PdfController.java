package com.grisbi.masterspringbootfinalproject.controller;

import com.grisbi.masterspringbootfinalproject.repository.Account;
import com.grisbi.masterspringbootfinalproject.repository.Person;
import com.grisbi.masterspringbootfinalproject.service.AccountService;
import com.grisbi.masterspringbootfinalproject.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PdfController {
    private final AccountService accountService;
    private final PdfService pdfService;

    @Autowired
    public PdfController(AccountService accountService, PdfService pdfService) {
        this.accountService = accountService;
        this.pdfService = pdfService;
    }

    @GetMapping("/account/{number}/pdf")
    public ResponseEntity<byte[]> generateUserPdf(@PathVariable long number) {
        try {
            Account account = accountService.findAccount(number)
                .orElseThrow(() -> new RuntimeException("Account not found"));

            byte[] pdfContents = pdfService.generatePdf(account);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline", "account_"+number+".pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfContents);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}
