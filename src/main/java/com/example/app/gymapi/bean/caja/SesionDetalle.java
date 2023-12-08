package com.example.app.gymapi.bean.caja;

import com.example.app.gymapi.abstracts.AbstractBean;
import com.example.app.gymapi.auth.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "sesion_detalles")
public class SesionDetalle extends AbstractBean {
    @ManyToOne
    @JoinColumn(name = "id_sesion")
    private SesionCaja sesion;
    @Column
    private double montoApertura;
    @Column
    private double montoCierre;
    @Column
    private Date horaApertura;
    @Column
    private Date horaCierre;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario user;
}
