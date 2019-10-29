package com.uter.controller;

import com.uter.entity.Driver;
import com.uter.entity.Trip;
import com.uter.entity.Vehicle;
import com.uter.service.DriverService;
import com.uter.service.TripService;
import com.uter.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/uter/trip")
public class TripController {

    @Autowired
    private TripService service;

    @Autowired
    private DriverService driverService;

    @GetMapping
    public ResponseEntity<Iterable<Trip>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Validated @RequestBody Trip trip) {
        Driver driver = driverService.findById(trip.getDriver().getId()).get();
        if(service.findByDriverAndDate(driver, trip.getDate()).isPresent()){
            return new ResponseEntity<>("Conductor ha sido seleccionado", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(service.create(trip));
    }

    @GetMapping("/driver/{id}")
    public ResponseEntity<Trip> findById(@PathVariable Long id) {
        Trip vehicle = service.findById(id).get();
        return ResponseEntity.ok(vehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> update(@PathVariable Long id, @Valid @RequestBody Trip trip) {
        if (service.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.update(trip));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!service.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
