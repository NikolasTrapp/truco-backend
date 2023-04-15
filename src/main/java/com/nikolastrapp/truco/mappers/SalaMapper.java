package com.nikolastrapp.truco.mappers;

import com.nikolastrapp.truco.dtos.SalaDto;
import com.nikolastrapp.truco.entities.Sala;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class SalaMapper {

    public Sala to(SalaDto dtoEntity) {
        Sala entity = new Sala();
        BeanUtils.copyProperties(dtoEntity, entity);
        return entity;
    }

    public SalaDto to(Sala entity) {
        SalaDto dtoEntity = new SalaDto();
        BeanUtils.copyProperties(entity, dtoEntity);
        return dtoEntity;
    }

    public List<SalaDto> toDtoList(List<Sala> entitiesList) {
        return new ArrayList<SalaDto>(entitiesList.stream().map(this::to).toList());
    }

    public List<Sala> toEntityList(List<SalaDto> entitiesDtoList) {
        return new ArrayList<Sala>(entitiesDtoList.stream().map(this::to).toList());
    }
}
