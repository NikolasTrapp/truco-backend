package com.nikolastrapp.truco.dtos;

import java.util.List;
import java.util.UUID;

public class EquipeDto {
    private UUID id;
    private Integer pontos;
    private List<JogadorDto> jogadores;
    private PartidaDto partida;
}
