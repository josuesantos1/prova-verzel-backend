package com.verzel.backend.Database.Repositories;

import com.verzel.backend.Database.Models.CarsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<CarsModel, String> {
}
