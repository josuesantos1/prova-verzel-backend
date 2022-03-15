package com.verzel.backend.Database.Repositories;

import com.verzel.backend.Database.Models.CarsModel;
import org.springframework.data.jpa.repository.JpaRepository;;import java.util.List;
import java.util.Optional;

public interface CarsRepository extends JpaRepository<CarsModel, String> {
    public Optional<List<CarsModel>> findAllByOwner(String owner);
}
