package com.nikolastrapp.truco.controllers;

import com.nikolastrapp.truco.dtos.EquipeDto;
import com.nikolastrapp.truco.entities.Equipe;
import com.nikolastrapp.truco.mappers.EquipeMapper;
import com.nikolastrapp.truco.services.EquipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/equipe")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    private EquipeMapper mapper = new EquipeMapper();


    @GetMapping
    public ResponseEntity<List<Equipe>> findAll() {
        return ResponseEntity.ok().body(this.equipeService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Equipe> findByid(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok().body(this.equipeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Equipe> save(@Valid @RequestBody EquipeDto equipeDto) {
        Equipe equipe = mapper.to(equipeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.equipeService.save(equipe));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id) {
        this.equipeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Equipe> update (@PathVariable(value = "id") UUID id,
                                        @Valid @RequestBody EquipeDto equipeDto) {
        Equipe equipe = mapper.to(equipeDto);
        return ResponseEntity.ok().body(this.equipeService.update(equipe));
    }
}
