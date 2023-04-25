package com.example.SNPGlobal.controller;

import com.example.SNPGlobal.entity.Person;
import com.example.SNPGlobal.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;
    @PostMapping()
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        Person person1 = personService.savePerson(person);
        return ResponseEntity.ok(person1);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Integer id){
        Optional<Person> person = personService.getPerson(id);
        return ResponseEntity.ok(person.get());
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getPersons(){
        List<Person> persons = personService.getPersons();
        return ResponseEntity.ok(persons);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Integer id){
        return ResponseEntity.ok(personService.deletePerson(id));
    }

    @GetMapping("/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<Person>> getAllPerson(@PathVariable("pageNumber") int pageNumber,
                                                     @PathVariable("pageSize") int pageSize){
        return ResponseEntity.ok(personService.getPersons(pageNumber,pageSize));
    }
}
