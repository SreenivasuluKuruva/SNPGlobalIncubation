package com.example.SNPGlobal.service;

import com.example.SNPGlobal.entity.Person;
import com.example.SNPGlobal.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person) {
        person.getVehicles().forEach(vehicle -> vehicle.setPerson(person));
        return personRepository.save(person);
    }

    public Optional<Person> getPerson(Integer id) {
        return personRepository.findById(id);
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public String deletePerson(Integer id) {
        personRepository.deleteById(id);
        return "Person deleted";
    }

    public Page<Person> getPersons(int pageNumber, int pageSize) {
        return personRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }


}
