package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class CarRepository {
    static int id = 0;
    private List<Car> carData = new ArrayList<>();

    public Car create(Car car) {
        if (car.getCarId() == null) {
            car.setCarId(UUID.randomUUID().toString());
        }
        carData.add(car);
        return car;
    }

    public Iterator<Car> findAll() {
        return carData.iterator();
    }

    public Car findById(String id) {
        for (Car car: carData) {
            if (car.getCarId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    public Car update(Car carBaru) {
        Car carLama = findById(carBaru.getCarId());
        if (carLama != null) {
            carLama.setCarName(carBaru.getCarName());
            carLama.setCarQuantity(carBaru.getCarQuantity());
            return carLama;
        }
        return null;
    }

    public Boolean delete(String id) {
        return carData.removeIf(car -> car.getCarId().equals(id));
    }
}
