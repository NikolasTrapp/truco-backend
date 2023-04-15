package com.nikolastrapp.truco.mappers;

import com.nikolastrapp.truco.dtos.JogadorDto;
import com.nikolastrapp.truco.entities.Jogador;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class JogadorMapper {

    public Jogador to(JogadorDto dtoEntity) {
        Jogador entity = new Jogador();
        BeanUtils.copyProperties(dtoEntity, entity);
        return entity;
    }

    public JogadorDto to(Jogador entity) {
        JogadorDto dtoEntity = new JogadorDto();
        BeanUtils.copyProperties(entity, dtoEntity);
        return dtoEntity;
    }

    public List<JogadorDto> toDtoList(List<Jogador> entitiesList) {
        return new ArrayList<JogadorDto>(entitiesList.stream().map(this::to).toList());
    }

    public List<Jogador> toEntityList(List<JogadorDto> entitiesDtoList) {
        return new ArrayList<Jogador>(entitiesDtoList.stream().map(this::to).toList());
    }
}
