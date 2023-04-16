package com.nikolastrapp.truco.services;

import com.nikolastrapp.truco.entities.Chat;
import com.nikolastrapp.truco.repositories.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }


    public List<Chat> findAll() {
        return this.chatRepository.findAll();
    }

    public Chat findById(final UUID id) {
        return this.chatRepository.findById(id).orElseThrow();
    }

    public Chat save(final Chat chat) {
        return this.chatRepository.save(chat);
    }

    public void delete(final UUID id) {
        this.chatRepository.delete(this.findById(id));
    }

    public Chat update(final Chat chatNovo) {
        Chat chatAntigo = this.findById(chatNovo.getId());
        this.update(chatNovo, chatAntigo);
        return this.chatRepository.save(chatAntigo);
    }

    public void update(final Chat chatNovo, final Chat chatAntigo) {

    }
}
