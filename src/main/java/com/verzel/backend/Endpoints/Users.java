package com.verzel.backend.Endpoints;

import com.verzel.backend.Database.Models.CarsModel;
import com.verzel.backend.Database.Models.UsersModel;
import com.verzel.backend.Handlers.UsersHandler;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class Users {
    private final UsersHandler handler;

    public Users(UsersHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UsersModel user) {
        UsersModel result = handler.create(user);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity view(@RequestParam String id) {
        Optional<UsersModel> result = handler.view(id);
        return ResponseEntity.ok(result);
    }
}
