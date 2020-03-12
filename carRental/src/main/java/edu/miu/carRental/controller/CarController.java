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
import edu.miu.carRental.domain.User;
import edu.miu.carRental.serviceImp.CarServiceImp;

@RestController
public class CarController {

    @Autowired
    private CarServiceImp carService;
    
    @GetMapping(value= {"/"})
    public String publicPage() {
		return "public pages";
    }
    
    @GetMapping(value= {"/login"})
    public String login() {
		return "home/login";
    }
    @GetMapping("/logout-success")
    public String logout() {
		return "home/logout";
    }
//   
//    @PreAuthorize("hasAnyRole('ADMIN')")
//    @GetMapping("/admin/home")
//    public String homeAdmin() {
//		return "home/admin";
//    }
//    @PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
//    @GetMapping("/employee/home")
//    public String homeEmployee() {
//		return "home/employee";
//    }
   
    
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

