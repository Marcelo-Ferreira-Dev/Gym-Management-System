package com.example.app.gymapi.dto.cliente;

import com.example.app.gymapi.abstracts.AbstractDto;
import jakarta.annotation.Nullable;
import lombok.Data;

import java.util.Date;

@Data
public class MedicionDto extends AbstractDto {
    private Double peso;
    private Double altura;
    private Double imc;
    private Date fecha;
    @Nullable
    private Long clienteId;
}
