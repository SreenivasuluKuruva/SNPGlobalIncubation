package com.example.SNPGlobal.service;

import com.example.SNPGlobal.entity.Person;
import com.example.SNPGlobal.repository.PersonRepository;
import com.example.SNPGlobal.service.PersonService;
import com.example.SNPGlobal.util.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @InjectMocks
    PersonService personServiceMock;
    @Mock
    private PersonRepository personRepositoryMock;
    @Test
    public void savePersonTest(){
        Mockito.when(personRepositoryMock.save(any())).thenReturn(getPerson());
        Person person = personServiceMock.savePerson(getPerson());
        Assertions.assertNotNull(person);
        Assertions.assertEquals("sreenivas",person.getName());
    }

    public Person getPerson(){
        Person p = new Person();
        p.setId(1);
        p.setName("sreenivas");
        p.setGender(Gender.MALE);
        return p;
    }
}
