package com.verzel.backend.Handlers;

import com.verzel.backend.Database.Models.UsersModel;
import com.verzel.backend.Database.Repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UsersHandler {
    private final UsersRepository userRepository;
    private final PasswordEncoder encoder;

    public UsersHandler(UsersRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public UsersModel create(UsersModel user) {
        UUID uuid = UUID.randomUUID();
        String[] id = uuid.toString().split("-");
        user.setId(id[0]);

        String password = user.getPassword();

        user.setPassword(encoder.encode(password));

        UsersModel result = userRepository.save(user);
        return result;
    }

    public Optional<UsersModel> view(String email) {
        Optional<UsersModel> result = userRepository.findByEmail(email);
        return result;
    }
}
