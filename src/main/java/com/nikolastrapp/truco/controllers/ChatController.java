package com.nikolastrapp.truco.controllers;

import com.nikolastrapp.truco.dtos.ChatDto;
import com.nikolastrapp.truco.entities.Chat;
import com.nikolastrapp.truco.mappers.ChatMapper;
import com.nikolastrapp.truco.services.ChatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    private ChatMapper mapper = new ChatMapper();


    @GetMapping
    public ResponseEntity<List<Chat>> findAll() {
        return ResponseEntity.ok().body(this.chatService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Chat> findByid(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok().body(this.chatService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Chat> save(@Valid @RequestBody ChatDto chatDto) {
        Chat chat = mapper.to(chatDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.chatService.save(chat));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id) {
        this.chatService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Chat> update (@PathVariable(value = "id") UUID id,
                                        @Valid @RequestBody ChatDto chatDto) {
        Chat chat = mapper.to(chatDto);
        return ResponseEntity.ok().body(this.chatService.update(chat));
    }
}
