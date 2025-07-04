package com.example.app.gymapi.bean.clientes;

import com.example.app.gymapi.abstracts.AbstractBean;
import lombok.Data;

@Data
public class Actividad extends AbstractBean {
    private String nombre;
    private String descripcion;
    private Integer costoMensual;
    private Integer costoSemanal;
}
