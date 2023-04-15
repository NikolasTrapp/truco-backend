package com.nikolastrapp.truco.repositories;

import com.nikolastrapp.truco.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartidaRepository extends JpaRepository<Partida, UUID> {
}