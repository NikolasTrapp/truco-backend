package com.nikolastrapp.truco.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class PartidaDto implements Serializable {
    private UUID id;
    private List<EquipeDto> equipes = new ArrayList<>();
    private SalaDto sala;
    private LocalDateTime data_criacao;

}