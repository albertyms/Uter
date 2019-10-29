package com.uter.service;

import com.uter.entity.Driver;
import com.uter.entity.Trip;
import com.uter.repository.TripRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TripService {
    private Logger logger = LogManager.getLogger(DriverService.class);

    @Autowired
    TripRepository repository;

    public Trip create(Trip trip) {
        try {
            return repository.save(trip);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Trip update(Trip trip) {
        try {
            Optional<Trip> tripUpdate = repository.findById(trip.getId());
            if (tripUpdate.isPresent()) {
                tripUpdate.get().setDate(trip.getDate());
                tripUpdate.get().setDriver(trip.getDriver());
                tripUpdate.get().setVehicle(trip.getVehicle());
                return repository.save(tripUpdate.get());
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

    public Optional<Trip> findById(Long id) {
        Optional<Trip> trip;
        try {
            trip = repository.findById(id);
            if(trip.isPresent()){
                return trip;
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Iterable<Trip> findAll() {
        Iterable<Trip> trips;
        try {
            trips = repository.findAll();
            return trips;
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Optional<Trip> findByDriverAndDate(Driver driver, Date date) {
        Optional<Trip> trip;
        try {
            trip = repository.findByDriverAndDate(driver, date);
            if(trip.isPresent()){
                return trip;
            } else {
                return trip;
            }
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }
}
