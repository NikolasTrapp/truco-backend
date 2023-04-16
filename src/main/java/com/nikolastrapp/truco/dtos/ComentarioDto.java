package com.nikolastrapp.truco.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ComentarioDto implements Serializable {
    private UUID id;
    private JogadorDto jogador;
    private ChatDto chat;
    private LocalDateTime data_envio;
}