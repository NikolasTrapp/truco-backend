package com.nikolastrapp.truco.repositories;

import com.nikolastrapp.truco.entities.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalaRepository extends JpaRepository<Sala, UUID> {
}