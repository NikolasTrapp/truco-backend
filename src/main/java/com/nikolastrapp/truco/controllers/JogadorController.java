package com.nikolastrapp.truco.controllers;

import com.nikolastrapp.truco.dtos.JogadorDto;
import com.nikolastrapp.truco.entities.Jogador;
import com.nikolastrapp.truco.mappers.JogadorMapper;
import com.nikolastrapp.truco.services.JogadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    private JogadorMapper mapper = new JogadorMapper();


    @GetMapping
    public ResponseEntity<List<Jogador>> findAll() {
        return ResponseEntity.ok().body(this.jogadorService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Jogador> findByid(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok().body(this.jogadorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Jogador> save(@Valid @RequestBody JogadorDto jogadorDto) {
        Jogador jogador = mapper.to(jogadorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.jogadorService.save(jogador));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id) {
        this.jogadorService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Jogador> update (@PathVariable(value = "id") UUID id,
                                        @Valid @RequestBody JogadorDto jogadorDto) {
        Jogador jogador = mapper.to(jogadorDto);
        return ResponseEntity.ok().body(this.jogadorService.update(jogador));
    }
}
