package com.nikolastrapp.truco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name="TB_EQUIPES")
public class Equipe implements Serializable {

    public Equipe (Integer pontos, Partida partida){
        this.pontos = pontos;
        this.partida = partida;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private Integer pontos;

    @OneToMany(mappedBy = "equipe")
    @JsonIgnore
    private List<Jogador> jogadores = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "partida_id", nullable = false)
    private Partida partida;
}
