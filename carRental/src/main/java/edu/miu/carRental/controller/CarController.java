package edu.miu.carRental.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.carRental.domain.Car;
import edu.miu.carRental.domain.User;
import edu.miu.carRental.serviceImp.CarServiceImp;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class CarController {

    @Autowired
    private CarServiceImp carService;
    
    
    @PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
    @GetMapping("employee/cars")
    public List<Car> getAllCars() {
        return carService.findAll();
    }
    @PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
    @GetMapping("employee/cars/{id}")
    public Car getCar(@PathVariable Long id){
        Car car= carService.findById(id);
        return car;
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("admin/cars")
    public Car addCar(@RequestBody Car car){
        return carService.save(car);
    }
    @PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
    @PutMapping("employee/cars")
    public Car updateCar(@RequestBody Car car){
        return carService.save(car);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value ="admin/cars/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.delete(id);
    }
}

