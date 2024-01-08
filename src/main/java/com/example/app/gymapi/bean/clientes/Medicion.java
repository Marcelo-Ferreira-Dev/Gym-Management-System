package com.example.app.gymapi.bean.clientes;

import com.example.app.gymapi.abstracts.AbstractBean;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "mediciones")
@Data
public class Medicion extends AbstractBean {
    private Double peso;
    private Double altura;
    private Double imc;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}