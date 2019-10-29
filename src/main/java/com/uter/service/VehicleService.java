package com.uter.service;

import com.uter.entity.Vehicle;
import com.uter.repository.VehicleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {
    private Logger logger = LogManager.getLogger(DriverService.class);

    @Autowired
    VehicleRepository repository;

    public Vehicle create(Vehicle vehicle) {
        try {
            return repository.save(vehicle);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Vehicle update(Vehicle vehicle) {
        try {
            Optional<Vehicle> vehicleUpdate = repository.findById(vehicle.getId());
            if (vehicleUpdate.isPresent()) {
                vehicleUpdate.get().setBrand(vehicle.getBrand());
                vehicleUpdate.get().setModel(vehicle.getModel());
                vehicleUpdate.get().setPlate(vehicle.getPlate());
                return repository.save(vehicleUpdate.get());
            }
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
        return null;
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error:", e);
        }
    }

    public Optional<Vehicle> findById(Long id) {
        Optional<Vehicle> vehicle;
        try {
            vehicle = repository.findById(id);
            if(vehicle.isPresent()){
                return vehicle;
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Iterable<Vehicle> findAll() {
        Iterable<Vehicle> vehicles;
        try {
            vehicles = repository.findAll();
            return vehicles;
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }
}
