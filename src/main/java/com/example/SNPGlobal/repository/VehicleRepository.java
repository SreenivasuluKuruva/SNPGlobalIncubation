package com.example.SNPGlobal.repository;

import com.example.SNPGlobal.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findTop2ByOrderByPriceDesc();
}
