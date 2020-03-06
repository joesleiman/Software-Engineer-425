package edu.miu.carRental.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.carRental.domain.Car;
import edu.miu.carRental.serviceImp.CarServiceImp;

@RestController
public class CarController {

    @Autowired
    private CarServiceImp carService;

    @GetMapping("admin/cars")
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping("/admin/cars/{id}")
    public Car getCar(@PathVariable Long id){
        Car car= carService.findById(id);
        return car;
    }
    
    @PostMapping("/admin/cars")
    public Car addCar(@RequestBody Car car){
        return carService.save(car);
    }

    @PutMapping("/admin/cars")
    public Car updateCar(@RequestBody Car car){
        return carService.save(car);
    }
    
    @DeleteMapping(value ="/admin/cars/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.delete(id);
    }
}

