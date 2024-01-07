package com.example.app.gymapi.dto;

import com.example.app.gymapi.abstracts.AbstractDto;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;

@Data
public class ClienteDto extends AbstractDto {
    @NotNull
    private String nombre;
    @NotNull
    private String cedula;
    @NotNull
    private String ruc;
    private String telefono;
    private String email;
    private String direccion;
    private Date fecha_registro;
}