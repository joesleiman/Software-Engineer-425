package edu.miu.carRental.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.carRental.domain.Car;
import edu.miu.carRental.serviceImp.CarServiceImp;

@Controller
public class CarController {

    @Autowired
    private CarServiceImp carService;
    
    @GetMapping("/login")
    public String login() {
		return "home/login";
    }
    @GetMapping("/logout-success")
    public String logout() {
		return "home/logout";
    }
    
    @PreAuthorize("hasAuthority('Employee')")
    @GetMapping("/")
    public String homeAdmin() {
		return "home/admin";
    }
   
    
    @PreAuthorize("hasAnyAuthority('Admin','Employee','Customer')")
    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carService.findAll();
    }
    @PreAuthorize("hasAnyAuthority('Admin','Employee')")
    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable Long id){
        Car car= carService.findById(id);
        return car;
    }
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/cars")
    public Car addCar(@RequestBody Car car){
        return carService.save(car);
    }
    @PreAuthorize("hasAnyAuthority('Admin','Employee')")
    @PutMapping("/cars")
    public Car updateCar(@RequestBody Car car){
        return carService.save(car);
    }
    @PreAuthorize("hasAuthority('Admin')")
    @DeleteMapping(value ="/cars/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.delete(id);
    }
}

