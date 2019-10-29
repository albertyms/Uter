package com.uter.controller;

import com.uter.entity.Driver;
import com.uter.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/uter/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping
    public ResponseEntity<Iterable<Driver>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Validated @RequestBody Driver driver) {
        return ResponseEntity.ok(service.create(driver));
    }

    @GetMapping("/driver/{id}")
    public ResponseEntity<Driver> findById(@PathVariable Long id) {
        Driver driver = service.findById(id).get();
        return ResponseEntity.ok(driver);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> update(@PathVariable Long id, @Valid @RequestBody Driver driver) {
        if (service.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.update(driver));
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
