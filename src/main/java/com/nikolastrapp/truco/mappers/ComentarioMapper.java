package com.nikolastrapp.truco.mappers;

import com.nikolastrapp.truco.dtos.ComentarioDto;
import com.nikolastrapp.truco.entities.Comentario;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class ComentarioMapper {

    public Comentario to(ComentarioDto dtoEntity) {
        Comentario entity = new Comentario();
        BeanUtils.copyProperties(dtoEntity, entity);
        return entity;
    }

    public ComentarioDto to(Comentario entity) {
        ComentarioDto dtoEntity = new ComentarioDto();
        BeanUtils.copyProperties(entity, dtoEntity);
        return dtoEntity;
    }

    public List<ComentarioDto> toDtoList(List<Comentario> entitiesList) {
        return new ArrayList<ComentarioDto>(entitiesList.stream().map(this::to).toList());
    }

    public List<Comentario> toEntityList(List<ComentarioDto> entitiesDtoList) {
        return new ArrayList<Comentario>(entitiesDtoList.stream().map(this::to).toList());
    }
}
