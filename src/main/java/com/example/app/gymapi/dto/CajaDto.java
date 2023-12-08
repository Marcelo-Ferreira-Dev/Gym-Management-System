package com.example.app.gymapi.dto;

import com.example.app.gymapi.abstracts.AbstractDto;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@Data
public class CajaDto extends AbstractDto {
    private String nombre;
    private boolean abierta;
}

