package com.example.SNPGlobal.service;

import com.example.SNPGlobal.entity.Vehicle;
import com.example.SNPGlobal.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleService {

    VehicleRepository vehicleRepository;
    public Vehicle updateVehicle(Vehicle vehicle){
        Optional<Vehicle> byId = vehicleRepository.findById(vehicle.getId());
        if (byId.isPresent()){
            Vehicle vehicle1 = byId.get();
            vehicle1.setVehicleName(vehicle.getVehicleName());
            vehicle1.setPrice(vehicle.getPrice());
            vehicle1.setPrice(vehicle.getPrice());
            return vehicleRepository.save(vehicle1);
        }
        return null;
    }

    public Vehicle addVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getTop2Vehicles(){
        return vehicleRepository.findTop2ByOrderByPriceDesc();
    }

    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }
}
