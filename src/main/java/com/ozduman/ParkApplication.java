package com.ozduman;

import com.ozduman.entity.ParkRide;
import com.ozduman.repository.ParkRideRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ParkApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(ParkRideRepository repository) {
        return (args) -> {
            repository.save(new ParkRide("test-name-1", "test-description-1", 5, 3));
            repository.save(new ParkRide("test-name-2", "test-description-2", 3, 2));
            repository.save(new ParkRide("test-name-3", "test-description-3", 2, 4));
        };
    }
}
