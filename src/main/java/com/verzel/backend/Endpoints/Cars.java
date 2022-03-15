package com.verzel.backend.Endpoints;

import com.verzel.backend.Database.Models.CarsModel;
import com.verzel.backend.Database.Repositories.CarsRepository;
import com.verzel.backend.Handlers.CarsHandler;
import com.verzel.backend.Libraries.Cloud.Storage;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
public class Cars {
    private final CarsHandler handler;

    public Cars(CarsHandler handler) {
        this.handler = handler;
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody CarsModel car) {
        Object email = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        car.setOwner((String) email);

        CarsModel result = handler.create(car);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/me")
    public ResponseEntity viewMe() {
        Object email = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        Optional<List<CarsModel>> result = handler.viewMe((String) email);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity view(@RequestParam String id) {
        Optional<CarsModel> result = handler.view(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/pagination")
    public ResponseEntity pagination() {
        List<CarsModel> result = handler.listview();
        return ResponseEntity.ok(result);
    }

    @PatchMapping
    public ResponseEntity update(@RequestBody CarsModel car) {
        CarsModel result = handler.update(car);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam String id) {
        handler.delete(id);
        return ResponseEntity.ok("deleted");
    }
}
