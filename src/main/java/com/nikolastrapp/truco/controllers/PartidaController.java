package com.nikolastrapp.truco.controllers;

import com.nikolastrapp.truco.dtos.PartidaDto;
import com.nikolastrapp.truco.entities.Partida;
import com.nikolastrapp.truco.mappers.PartidaMapper;
import com.nikolastrapp.truco.services.PartidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/partida")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    private PartidaMapper mapper = new PartidaMapper();


    @GetMapping
    public ResponseEntity<List<Partida>> findAll() {
        return ResponseEntity.ok().body(this.partidaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Partida> findByid(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok().body(this.partidaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Partida> save(@Valid @RequestBody PartidaDto partidaDto) {
        Partida partida = mapper.to(partidaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.partidaService.save(partida));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id) {
        this.partidaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Partida> update (@PathVariable(value = "id") UUID id,
                                        @Valid @RequestBody PartidaDto partidaDto) {
        Partida partida = mapper.to(partidaDto);
        return ResponseEntity.ok().body(this.partidaService.update(partida));
    }
}
