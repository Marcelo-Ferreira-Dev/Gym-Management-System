package com.example.app.gymapi.bean.clientes;

import com.example.app.gymapi.abstracts.AbstractBean;
import lombok.Data;

import java.util.Date;

@Data
public class Suscripcion extends AbstractBean {
    private Actividad actividad;
    private SuscripcionEstadoEnum estado;
    private SuscripcionModalidadEnum modalidad;
    private Date fechaInicio;
    private Date fechaFin;
}