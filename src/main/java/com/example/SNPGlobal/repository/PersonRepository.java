package com.example.SNPGlobal.repository;

import com.example.SNPGlobal.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    @EntityGraph(attributePaths = "vehicles")
    List<Person> findAll();

    Page<Person> findAll(Pageable pageable);
}
