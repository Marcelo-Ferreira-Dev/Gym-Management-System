package com.example.app.gymapi.dto.cliente;

import com.example.app.gymapi.abstracts.AbstractDto;
import lombok.Data;

@Data
public class ActividadDto extends AbstractDto {
    private String nombre;
    private String descripcion;
    private Integer costoMensual;
    private Integer costoSemanal;
}
