package com.grisbi.masterspringbootfinalproject.service;

import com.grisbi.masterspringbootfinalproject.domain.StringPayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class StringUtilitiesServiceTest {
    @InjectMocks
    StringUtilitiesService springUtilities;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void whenStringNotNull_thenReturnUpperCase(){
        String test = "abcde";
        String expected = "ABCDE";

        String result = springUtilities.welcome(new StringPayload(test)).toString();
        assert result.equals(expected);
    }
}
