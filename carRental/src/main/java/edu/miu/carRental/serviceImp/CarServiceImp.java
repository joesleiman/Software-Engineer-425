package edu.miu.carRental.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.carRental.domain.Car;
import edu.miu.carRental.repository.CarRepository;
import edu.miu.carRental.service.CarService;

@Service
public class CarServiceImp implements CarService{
	@Autowired
	private CarRepository carRepository;

	public List<Car> findAll() {
		return carRepository.findAll();
	}

	public Car findById(Long id) {
		return carRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Car with id : " + id+" is not available"));
	}

	public Car save(Car car) {
		carRepository.save(car);
		return car;
	}

	// boolean existsById(ID id)
	public void delete(Long id) {
		Car car=carRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Car with id : " + id+" is not available"));
		
		carRepository.delete(car);
	}

}
