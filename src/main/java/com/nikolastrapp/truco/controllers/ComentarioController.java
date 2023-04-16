package com.nikolastrapp.truco.controllers;

import com.nikolastrapp.truco.dtos.ComentarioDto;
import com.nikolastrapp.truco.entities.Comentario;
import com.nikolastrapp.truco.mappers.ComentarioMapper;
import com.nikolastrapp.truco.services.ComentarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    private ComentarioMapper mapper = new ComentarioMapper();


    @GetMapping
    public ResponseEntity<List<Comentario>> findAll() {
        return ResponseEntity.ok().body(this.comentarioService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Comentario> findByid(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok().body(this.comentarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Comentario> save(@Valid @RequestBody ComentarioDto comentarioDto) {
        Comentario comentario = mapper.to(comentarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.comentarioService.save(comentario));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id) {
        this.comentarioService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Comentario> update (@PathVariable(value = "id") UUID id,
                                        @Valid @RequestBody ComentarioDto comentarioDto) {
        Comentario comentario = mapper.to(comentarioDto);
        return ResponseEntity.ok().body(this.comentarioService.update(comentario));
    }
}
