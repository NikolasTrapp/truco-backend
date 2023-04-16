package com.nikolastrapp.truco.mappers;

import com.nikolastrapp.truco.dtos.EquipeDto;
import com.nikolastrapp.truco.entities.Equipe;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class EquipeMapper {

    public Equipe to(EquipeDto dtoEntity) {
        Equipe entity = new Equipe();
        BeanUtils.copyProperties(dtoEntity, entity);
        return entity;
    }

    public EquipeDto to(Equipe entity) {
        EquipeDto dtoEntity = new EquipeDto();
        BeanUtils.copyProperties(entity, dtoEntity);
        return dtoEntity;
    }

    public List<EquipeDto> toDtoList(List<Equipe> entitiesList) {
        return new ArrayList<EquipeDto>(entitiesList.stream().map(this::to).toList());
    }

    public List<Equipe> toEntityList(List<EquipeDto> entitiesDtoList) {
        return new ArrayList<Equipe>(entitiesDtoList.stream().map(this::to).toList());
    }
}
