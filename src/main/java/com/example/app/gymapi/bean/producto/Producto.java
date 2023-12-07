package com.example.app.gymapi.bean.producto;

import com.example.app.gymapi.abstracts.AbstractBean;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto extends AbstractBean {
    @Column
    private String nombre;
    @Column
    private String codigo;
    @Column
    private String descripcion;
    @Column
    private double precio;
    @Column
    private int cantidad;
    @Column
    private double iva;
    @Column
    private double costoCompra;
    @Column
    private boolean activo;
}
