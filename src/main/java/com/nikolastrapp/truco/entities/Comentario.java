package com.nikolastrapp.truco.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "TB_COMENTARIO")
public class Comentario implements Serializable {

    public Comentario(Jogador jogador, Chat chat, LocalDateTime data_envio) {
        this.jogador = jogador;
        this.chat = chat;
        this.data_envio = data_envio;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "jogador_id", nullable = true)
    private Jogador jogador;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data_envio;

}
