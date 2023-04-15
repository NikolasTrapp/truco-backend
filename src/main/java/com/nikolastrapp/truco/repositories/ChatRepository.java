package com.nikolastrapp.truco.repositories;

import com.nikolastrapp.truco.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {
}