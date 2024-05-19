package com.grisbi.masterspringbootfinalproject.service;

import com.grisbi.masterspringbootfinalproject.domain.StringPayload;
import org.springframework.stereotype.Service;

@Service
public class StringUtilitiesService {
   public StringPayload welcome(StringPayload payload){
       String temp = "Hola " + payload.name() + ", bienvenido a Mi Banco.";
       return  new StringPayload(temp);
    }
}
