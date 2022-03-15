package com.verzel.backend.Handlers;

import com.verzel.backend.Database.Models.CarsModel;
import com.verzel.backend.Database.Repositories.CarsRepository;
import com.verzel.backend.Libraries.Cloud.Storage;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CarsHandler {

    public final CarsRepository carsRepository;
    private final Storage storage;

    public CarsHandler(CarsRepository carsRepository, Storage storage) {
        this.carsRepository = carsRepository;
        this.storage = storage;
    }

    public CarsModel create(CarsModel car) {
        String uuid = UUID.randomUUID().toString();
        String[] id = uuid.split("-");
        car.setId(id[0]);

        CarsModel carsModel = new CarsModel();

        String filename = UUID.randomUUID() + car.getPhoto();

        URL url = storage.putPresignedUrl(filename);
        car.setPhoto(filename);
        CarsModel result = carsRepository.save(car);

        result.setPhoto(url.toString());

        return result;
    }

    public Optional<List<CarsModel>> viewMe(String owner) {
        Optional<List<CarsModel>> result = carsRepository.findAllByOwner(owner);

        for (CarsModel car: result.get()) {
            String url = storage.getPresignedUrl(car.getPhoto()).toString();
            car.setPhoto(url);
        }

        return result;
    }

    public Optional<CarsModel> view(String id) {
        Optional<CarsModel> result = carsRepository.findById(id);

        String url = storage.getPresignedUrl(result.get().getPhoto()).toString();
        result.orElseThrow().setPhoto(url);

        return result;
    }

    public List<CarsModel> listview() {
        return carsRepository.findAll();
    }

    public CarsModel update(CarsModel car) {
        return carsRepository.save(car);
    }

    public void delete(String id) {
        carsRepository.deleteById(id);
    }
}
