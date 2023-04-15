package com.nikolastrapp.truco.mappers;

import com.nikolastrapp.truco.dtos.PartidaDto;
import com.nikolastrapp.truco.entities.Partida;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class PartidaMapper {

    public Partida to(PartidaDto dtoEntity) {
        Partida entity = new Partida();
        BeanUtils.copyProperties(dtoEntity, entity);
        return entity;
    }

    public PartidaDto to(Partida entity) {
        PartidaDto dtoEntity = new PartidaDto();
        BeanUtils.copyProperties(entity, dtoEntity);
        return dtoEntity;
    }

    public List<PartidaDto> toDtoList(List<Partida> entitiesList) {
        return new ArrayList<PartidaDto>(entitiesList.stream().map(this::to).toList());
    }

    public List<Partida> toEntityList(List<PartidaDto> entitiesDtoList) {
        return new ArrayList<Partida>(entitiesDtoList.stream().map(this::to).toList());
    }
}
