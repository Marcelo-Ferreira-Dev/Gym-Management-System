package com.example.app.gymapi.dto;

import com.example.app.gymapi.abstracts.AbstractDto;
import lombok.Data;
import java.util.Date;

@Data
public class ClienteDto extends AbstractDto {
    private String nombre;
    private String cedula;
    private String ruc;
    private String telefono;
    private String email;
    private String direccion;
    private Date fecha_registro;
}