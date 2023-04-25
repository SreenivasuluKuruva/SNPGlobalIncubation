package com.example.SNPGlobal.controller;

import com.example.SNPGlobal.entity.Person;
import com.example.SNPGlobal.service.PersonService;
import com.example.SNPGlobal.util.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void savePersonTest() throws Exception {

        given(personService.savePerson(any(Person.class))).willReturn(new Person(null, "sreenivas", 20, "Hyd", Gender.MALE, null));
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new Person(null, "sreenivas", 20, "Hyd", Gender.MALE, null)))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
    }

    @Test
    public void getPersonByIdTest() throws Exception {

        given(personService.getPerson(any(Integer.class)))
                .willReturn(Optional.of(new Person(null, "sreenivas", 20, "Hyd", Gender.MALE, null)));
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/persons/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("sreenivas"));
    }

    @Test
    public void getPersonsTest() throws Exception {

        given(personService.getPersons())
                .willReturn(List.of(new Person(null, "sreenivas", 20, "Hyd", Gender.MALE, null)));
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/persons")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("sreenivas"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
