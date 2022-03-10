package com.verzel.backend.Handlers;

import com.verzel.backend.Database.Models.CarsModel;
import com.verzel.backend.Database.Repositories.CarsRepository;
import com.verzel.backend.Database.Validators.CarsValidator;
import com.verzel.backend.Libraries.Errors;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CarsHandler {

    public final CarsRepository carsRepository;
    public final CarsValidator carsValidator;

    public CarsHandler(CarsRepository carsRepository, CarsValidator carsValidator) {
        this.carsRepository = carsRepository;
        this.carsValidator = carsValidator;
    }

    public CarsModel create(CarsModel car) {

        List<Errors> errors = carsValidator.validate(car);

        if (errors.size() > 0) {
            System.out.println("\n\n error \n\n");
        }

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
