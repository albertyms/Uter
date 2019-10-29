package com.uter.repository;

import com.uter.entity.Driver;
import com.uter.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    Optional<Trip> findByDriverAndDate(Driver driver, Date date);
}
