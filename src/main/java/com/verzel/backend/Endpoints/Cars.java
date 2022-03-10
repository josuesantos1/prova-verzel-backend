package com.verzel.backend.Endpoints;

import com.verzel.backend.Database.Models.CarsModel;
import com.verzel.backend.Handlers.CarsHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class Cars {
    private final CarsHandler handler;

    public Cars(CarsHandler handler) {
        this.handler = handler;
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody CarsModel car) {
        CarsModel result = handler.create(car);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity view(@RequestParam String id) {
        Optional<CarsModel> result = handler.view(id);
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
