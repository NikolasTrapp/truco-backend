package com.nikolastrapp.truco.controllers;

import com.nikolastrapp.truco.dtos.SalaDto;
import com.nikolastrapp.truco.entities.Sala;
import com.nikolastrapp.truco.mappers.SalaMapper;
import com.nikolastrapp.truco.services.SalaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaService salaService;

    private SalaMapper mapper = new SalaMapper();


    @GetMapping
    public ResponseEntity<List<Sala>> findAll() {
        return ResponseEntity.ok().body(this.salaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sala> findByid(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok().body(this.salaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Sala> save(@Valid @RequestBody SalaDto salaDto) {
        Sala sala = mapper.to(salaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.salaService.save(sala));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id) {
        this.salaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Sala> update (@PathVariable(value = "id") UUID id,
                                        @Valid @RequestBody SalaDto salaDto) {
        Sala sala = mapper.to(salaDto);
        return ResponseEntity.ok().body(this.salaService.update(sala));
    }
}
