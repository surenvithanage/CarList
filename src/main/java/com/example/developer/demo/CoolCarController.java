package com.example.developer.demo;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CoolCarController {
	@Autowired
	private CarRepository repository;
	
	@GetMapping("/cool-cars")
	public Collection<Car> coolCars(){
		return repository.findAll().stream().filter(this::isCool).collect(Collectors.toList());
	}
	
	public boolean isCool(Car car) {
		return !car.getName().equals("AMC Gremlin") &&
				!car.getName().equals("Ford Pinto") &&
				!car.getName().equals("Yogo GV") &&
				!car.getName().equals("Triumph Stag");
	}

}
