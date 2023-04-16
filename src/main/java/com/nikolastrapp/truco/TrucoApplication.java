package com.nikolastrapp.truco;

import com.nikolastrapp.truco.entities.*;
import com.nikolastrapp.truco.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class TrucoApplication {

    private final ChatRepository chatRepository;
    private final ComentarioRepository comentarioRepository;
    private final EquipeRepository equipeRepository;
    private final JogadorRepository jogadorRepository;
    private final PartidaRepository partidaRepository;
    private final SalaRepository salaRepository;

    public TrucoApplication(ChatRepository chatRepository, ComentarioRepository comentarioRepository, EquipeRepository equipeRepository, JogadorRepository jogadorRepository, PartidaRepository partidaRepository, SalaRepository salaRepository) {
        this.chatRepository = chatRepository;
        this.comentarioRepository = comentarioRepository;
        this.equipeRepository = equipeRepository;
        this.jogadorRepository = jogadorRepository;
        this.partidaRepository = partidaRepository;
        this.salaRepository = salaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TrucoApplication.class, args);
    }

}
