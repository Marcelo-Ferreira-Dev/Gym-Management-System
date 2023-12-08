package com.example.app.gymapi.dto;

import com.example.app.gymapi.abstracts.AbstractDto;
import com.example.app.gymapi.auth.Usuario;
import com.example.app.gymapi.bean.caja.SesionCaja;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class SesionDetalleDto extends AbstractDto {
    private Long sesionID;
    private double montoApertura;
    private double montoCierre;
    private Date horaApertura;
    private Date horaCierre;
    private Long userID;
}
