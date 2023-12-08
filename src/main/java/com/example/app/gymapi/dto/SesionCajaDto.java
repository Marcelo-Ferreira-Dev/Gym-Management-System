package com.example.app.gymapi.dto;

import com.example.app.gymapi.abstracts.AbstractDto;
import com.example.app.gymapi.bean.caja.Caja;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class SesionCajaDto extends AbstractDto {
    private Long cajaID;
    private Date fecha;
    private boolean cerrado;
}
