package com.nikolastrapp.truco.repositories;

import com.nikolastrapp.truco.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipeRepository extends JpaRepository<Equipe, UUID> {
}