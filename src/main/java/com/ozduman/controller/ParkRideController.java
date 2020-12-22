package com.ozduman.controller;

import com.ozduman.entity.ParkRide;
import com.ozduman.repository.ParkRideRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class ParkRideController {
    private final ParkRideRepository parkRideRepository;

    public ParkRideController(ParkRideRepository parkRideRepository) {
        this.parkRideRepository = parkRideRepository;
    }

    @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ParkRide> getRides() {
        return parkRideRepository.findAll();
    }

    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ParkRide getRide(@PathVariable long id) {
        return parkRideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }

    @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ParkRide createRide(@Valid @RequestBody ParkRide parkRide) {
        return parkRideRepository.save(parkRide);
    }
}