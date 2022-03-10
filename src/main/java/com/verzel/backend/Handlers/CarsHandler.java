package com.verzel.backend.Handlers;

import com.verzel.backend.Database.Models.CarsModel;
import com.verzel.backend.Database.Repositories.CarsRepository;
import com.verzel.backend.Libraries.Errors;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CarsHandler {

    public final CarsRepository carsRepository;

    public CarsHandler(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public CarsModel create(CarsModel car) {
        UUID uuid = UUID.randomUUID();
        String[] id = uuid.toString().split("-");
        car.setId(id[0]);

        CarsModel result = carsRepository.save(car);
        return result;
    }

    public Optional<CarsModel> view(String id) {
        Optional<CarsModel> result = carsRepository.findById(id);

        return result;
    }

    public CarsModel update(CarsModel car) {
        CarsModel result = carsRepository.save(car);
        return result;
    }

    public void delete(String id) {
        carsRepository.deleteById(id);
    }
}
