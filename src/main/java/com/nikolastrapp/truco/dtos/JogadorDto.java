package com.nikolastrapp.truco.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class JogadorDto implements Serializable {

    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private Integer num_vitorias;
    private EquipeDto equipe;
    private List<ComentarioDto> comentarios = new ArrayList<>();
}