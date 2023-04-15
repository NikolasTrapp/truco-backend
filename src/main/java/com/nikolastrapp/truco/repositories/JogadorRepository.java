package com.nikolastrapp.truco.repositories;

import com.nikolastrapp.truco.entities.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JogadorRepository extends JpaRepository<Jogador, UUID> {
}