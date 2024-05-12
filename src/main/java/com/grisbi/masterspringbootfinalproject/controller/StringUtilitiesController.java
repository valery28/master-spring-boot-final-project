package com.grisbi.masterspringbootfinalproject.controller;

import com.grisbi.masterspringbootfinalproject.service.StringUtilitiesService;
import com.grisbi.masterspringbootfinalproject.domain.StringPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringUtilitiesController {
    private final StringUtilitiesService stringUtilitiesService;

    @Autowired
    public StringUtilitiesController(StringUtilitiesService stringUtilitiesService) {
        this.stringUtilitiesService = stringUtilitiesService;
    }

    @PostMapping("/welcome")
    public @ResponseBody StringPayload toUpperCase(@RequestBody StringPayload payload){
        return stringUtilitiesService.welcome(payload);
    }
}

