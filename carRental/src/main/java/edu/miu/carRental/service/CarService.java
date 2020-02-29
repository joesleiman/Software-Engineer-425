package edu.miu.carRental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.carRental.domain.Car;
import edu.miu.carRental.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository carRepository;

	public List<Car> findAll() {
		// TODO Auto-generated method stub
		return carRepository.findAll();
	}

	public Car findById(Integer id) {
		// TODO Auto-generated method stub
		
		return carRepository.findById(id).orElse(new Car());
	}

	public Car save(Car car) {
		// TODO Auto-generated method stub
		carRepository.save(car);
		return car;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		carRepository.deleteById(id);
		
	}

}
