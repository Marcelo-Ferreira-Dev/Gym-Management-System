package com.example.app.gymapi.bean.caja;

import com.example.app.gymapi.abstracts.AbstractBean;
import com.example.app.gymapi.auth.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "sesiones_caja")
public class SesionCaja extends AbstractBean {
    @ManyToOne
    @JoinColumn(name = "id_caja")
    private Caja caja;
    @Column
    private Date fecha;
    @Column
    private boolean cerrado;


}
