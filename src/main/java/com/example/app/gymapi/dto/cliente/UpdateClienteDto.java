package com.example.app.gymapi.dto.cliente;

import com.example.app.gymapi.abstracts.AbstractDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateClienteDto extends ClienteDto {
    private String nombre;
    private String cedula;
    private String ruc;
}