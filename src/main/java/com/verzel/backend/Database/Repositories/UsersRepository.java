package com.verzel.backend.Database.Repositories;

import com.verzel.backend.Database.Models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, String> {
    public Optional<UsersModel> findByEmail(String email);
}
