package edu.miu.carRental.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.carRental.domain.Car;
import edu.miu.carRental.service.CarService;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("admin/cars")
    public List<Car> getAllAdmins() {
        return carService.findAll();
    }

    @GetMapping("/admin/cars/{id}")
    public Car getAdmin(@PathVariable Integer id){
        Car car= carService.findById(id);
        return car;
    }
    
    @PostMapping("/admin/cars")
    public Car addAdmin(@RequestBody Car car){
        return carService.save(car);
    }

    @PutMapping("/admin/cars")
    public Car updateAdmin(@RequestBody Car car){
        return carService.save(car);
    }
    
    @DeleteMapping(value ="/admin/cars/{id}")
    public void deleteAdmin(@PathVariable Integer id){
        carService.delete(id);
    }
}

