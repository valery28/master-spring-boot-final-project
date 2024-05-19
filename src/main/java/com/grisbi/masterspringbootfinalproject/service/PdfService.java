package com.grisbi.masterspringbootfinalproject.service;

import com.grisbi.masterspringbootfinalproject.repository.Account;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {
    private final SpringTemplateEngine templateEngine;

    @Autowired
    public PdfService(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public byte[] generatePdf(Account account) {
        Context context = new Context();
        context.setVariable("account", account);

        String htmlContent = templateEngine.process("account-pdf", context);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        HtmlConverter.convertToPdf(htmlContent, byteArrayOutputStream, converterProperties);

        return byteArrayOutputStream.toByteArray();
    }
}
