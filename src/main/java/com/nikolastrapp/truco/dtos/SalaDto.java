package com.nikolastrapp.truco.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class SalaDto implements Serializable {
    private UUID id;
    private PartidaDto partida;
    private ChatDto chat;
}