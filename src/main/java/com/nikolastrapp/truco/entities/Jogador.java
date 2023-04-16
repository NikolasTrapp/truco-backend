package com.nikolastrapp.truco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "TB_JOGADORES")
public class Jogador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String nome;

    @Column(unique = true)
    private String email;

    @Column
    private String senha;

    @Column
    private Integer num_vitorias;

    @ManyToOne
    @JoinColumn(name = "equipe_id", nullable = false)
    private Equipe equipe;

    @OneToMany(mappedBy = "jogador")
    @JsonIgnore
    private List<Comentario> comentarios = new ArrayList<>();

    @Transient
    private List<Carta> cartas = new ArrayList<>();

    public void addCarta(Carta carta) {
        this.cartas.add(carta);
    }
}
