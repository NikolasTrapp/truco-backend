package com.nikolastrapp.truco.services;

import com.nikolastrapp.truco.entities.Jogador;
import com.nikolastrapp.truco.repositories.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }


    public List<Jogador> findAll() {
        return this.jogadorRepository.findAll();
    }

    public Jogador findById(final UUID id) {
        return this.jogadorRepository.findById(id).orElseThrow();
    }

    public Jogador save(final Jogador jogador) {
        return this.jogadorRepository.save(jogador);
    }

    public void delete(final UUID id) {
        this.jogadorRepository.delete(this.findById(id));
    }

    public Jogador update(final Jogador jogadorNovo) {
        Jogador jogadorAntigo = this.findById(jogadorNovo.getId());
        this.update(jogadorNovo, jogadorAntigo);
        return this.jogadorRepository.save(jogadorAntigo);
    }

    public void update(final Jogador jogadorNovo, final Jogador jogadorAntigo) {
        if (jogadorNovo.getNome() != null && jogadorNovo.getNome().isBlank()) {
            jogadorAntigo.setNome(jogadorNovo.getNome());
        }
    }
}
