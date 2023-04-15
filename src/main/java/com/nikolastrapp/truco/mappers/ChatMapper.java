package com.nikolastrapp.truco.mappers;

import com.nikolastrapp.truco.dtos.ChatDto;
import com.nikolastrapp.truco.entities.Chat;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class ChatMapper {

    public Chat to(ChatDto dtoEntity) {
        Chat entity = new Chat();
        BeanUtils.copyProperties(dtoEntity, entity);
        return entity;
    }

    public ChatDto to(Chat entity) {
        ChatDto dtoEntity = new ChatDto();
        BeanUtils.copyProperties(entity, dtoEntity);
        return dtoEntity;
    }

    public List<ChatDto> toDtoList(List<Chat> entitiesList) {
        return new ArrayList<ChatDto>(entitiesList.stream().map(this::to).toList());
    }

    public List<Chat> toEntityList(List<ChatDto> entitiesDtoList) {
        return new ArrayList<Chat>(entitiesDtoList.stream().map(this::to).toList());
    }
}
