package com.nikolastrapp.truco.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ChatDto implements Serializable {
    private  UUID id;
}