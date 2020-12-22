package com.ozduman.repository;
import com.ozduman.entity.ParkRide;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkRideRepository extends CrudRepository<ParkRide, Long> {
    List<ParkRide> findByName(String name);
}