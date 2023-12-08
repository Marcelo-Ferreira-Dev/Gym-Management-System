package com.example.app.gymapi.bean.caja;

import com.example.app.gymapi.abstracts.AbstractBean;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cajas")
public class Caja extends AbstractBean {
    @Column
    private String nombre;
    @Column
    private boolean abierta;
}
