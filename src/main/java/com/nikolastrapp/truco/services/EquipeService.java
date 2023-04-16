package com.nikolastrapp.truco.services;

import com.nikolastrapp.truco.entities.Equipe;
import com.nikolastrapp.truco.repositories.EquipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipeService {

    private final EquipeRepository equipeRepository;

    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }


    public List<Equipe> findAll(){
        return this.equipeRepository.findAll();
    }

    public Equipe findById(final UUID id){
        return this.equipeRepository.findById(id).orElseThrow();
    }

    public Equipe save(final Equipe equipe){
        return this.equipeRepository.save(equipe);
    }

    public void delete(final UUID id){
        this.equipeRepository.delete(this.findById(id));
    }

    public Equipe update(final Equipe equipeNovo){
        Equipe equipeAntigo = this.findById(equipeNovo.getId());
        this.update(equipeNovo, equipeAntigo);
        return this.equipeRepository.save(equipeAntigo);
    }

    public void update(final Equipe equipeNovo, final Equipe equipeAntigo){

    }
}
