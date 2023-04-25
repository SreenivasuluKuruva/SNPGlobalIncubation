package com.example.SNPGlobal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
    @Id
    @GeneratedValue
    private Integer id;

    private String vehicleName;
    private String model;
    private Long price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Person person;
}
