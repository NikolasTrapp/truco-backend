package com.nikolastrapp.truco.services;

import com.nikolastrapp.truco.entities.Comentario;
import com.nikolastrapp.truco.repositories.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }


    public List<Comentario> findAll(){
        return this.comentarioRepository.findAll();
    }

    public Comentario findById(final UUID id){
        return this.comentarioRepository.findById(id).orElseThrow();
    }

    public Comentario save(final Comentario comentario){
        return this.comentarioRepository.save(comentario);
    }

    public void delete(final UUID id){
        this.comentarioRepository.delete(this.findById(id));
    }

    public Comentario update(final Comentario comentarioNovo){
        Comentario comentarioAntigo = this.findById(comentarioNovo.getId());
        this.update(comentarioNovo, comentarioAntigo);
        return this.comentarioRepository.save(comentarioAntigo);
    }

    public void update(final Comentario comentarioNovo, final Comentario comentarioAntigo){

    }
}
