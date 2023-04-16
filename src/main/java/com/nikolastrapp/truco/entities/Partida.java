package com.nikolastrapp.truco.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "TB_PARTIDA")
public class Partida implements Serializable {

    public Partida(LocalDateTime data_criacao) {
        this.data_criacao = data_criacao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(mappedBy = "partida")
    @JsonIgnore
    private List<Equipe> equipes = new ArrayList<>();


    @OneToOne(mappedBy = "partida")
    private Sala sala;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data_criacao;

    @Column
    private Integer rodadas;

    @Column
    private Integer turno;

    private Integer pontos;

}
