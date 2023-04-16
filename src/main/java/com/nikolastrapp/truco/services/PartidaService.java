package com.nikolastrapp.truco.services;

import com.nikolastrapp.truco.entities.Partida;
import com.nikolastrapp.truco.repositories.PartidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PartidaService {

    private final PartidaRepository partidaRepository;

    public PartidaService(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }


    public List<Partida> findAll(){
        return this.partidaRepository.findAll();
    }

    public Partida findById(final UUID id){
        return this.partidaRepository.findById(id).orElseThrow();
    }

    public Partida save(final Partida partida){
        return this.partidaRepository.save(partida);
    }

    public void delete(final UUID id){
        this.partidaRepository.delete(this.findById(id));
    }

    public Partida update(final Partida partidaNovo){
        Partida partidaAntigo = this.findById(partidaNovo.getId());
        this.update(partidaNovo, partidaAntigo);
        return this.partidaRepository.save(partidaAntigo);
    }

    public void update(final Partida partidaNovo, final Partida partidaAntigo){

    }
}
