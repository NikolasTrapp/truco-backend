package com.nikolastrapp.truco.repositories;

import com.nikolastrapp.truco.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComentarioRepository extends JpaRepository<Comentario, UUID> {
}