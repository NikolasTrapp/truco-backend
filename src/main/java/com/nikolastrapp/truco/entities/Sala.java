package com.nikolastrapp.truco.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name="TB_SALAS")
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "partida_id", referencedColumnName = "id", nullable = false)
    private Partida partida;

    @OneToOne(mappedBy = "sala")
    private Chat chat;

}
