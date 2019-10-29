package com.uter.service;

import com.uter.entity.Driver;
import com.uter.repository.DriverRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {
    private Logger logger = LogManager.getLogger(DriverService.class);

    @Autowired
    DriverRepository repository;

    public Driver create(Driver driver) {
        try {
            return repository.save(driver);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Driver update(Driver driver) {
        try {
            Optional<Driver> driverUpdate = repository.findById(driver.getId());
            if (driverUpdate.isPresent()) {
                driverUpdate.get().setName(driver.getName());
                driverUpdate.get().setSurName(driver.getSurName());
                driverUpdate.get().setLicense(driver.getLicense());
                return repository.save(driverUpdate.get());
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

    public Optional<Driver> findById(Long id) {
        Optional<Driver> driver;
        try {
            driver = repository.findById(id);
            if(driver.isPresent()){
                return driver;
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Iterable<Driver> findAll() {
        Iterable<Driver> drivers;
        try {
            drivers = repository.findAll();
            return drivers;
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }
}
