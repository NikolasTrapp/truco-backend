package com.nikolastrapp.truco.services;

import com.nikolastrapp.truco.entities.Sala;
import com.nikolastrapp.truco.repositories.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SalaService {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }


    public List<Sala> findAll(){
        return this.salaRepository.findAll();
    }

    public Sala findById(final UUID id){
        return this.salaRepository.findById(id).orElseThrow();
    }

    public Sala save(final Sala sala){
        return this.salaRepository.save(sala);
    }

    public void delete(final UUID id){
        this.salaRepository.delete(this.findById(id));
    }

    public Sala update(final Sala salaNovo){
        Sala salaAntigo = this.findById(salaNovo.getId());
        this.update(salaNovo, salaAntigo);
        return this.salaRepository.save(salaAntigo);
    }

    public void update(final Sala salaNovo, final Sala salaAntigo){

    }
}
