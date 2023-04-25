package com.example.SNPGlobal.controller;

import com.example.SNPGlobal.entity.Vehicle;
import com.example.SNPGlobal.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {

    VehicleService vehicleService;
    @PutMapping()
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle){
        return ResponseEntity.ok(vehicleService.updateVehicle(vehicle));
    }
    @PostMapping()
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle){
        return ResponseEntity.ok(vehicleService.addVehicle(vehicle));
    }
    @GetMapping("/getTop2vehicles")
    public ResponseEntity<List<Vehicle>> getTop2Vehicles(){
        List<Vehicle> top2Vehicles = vehicleService.getTop2Vehicles();
        if(top2Vehicles.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(top2Vehicles);
    }

    @GetMapping()
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        List<Vehicle> top2Vehicles = vehicleService.getVehicles();
        if(top2Vehicles.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(top2Vehicles);
    }
}
