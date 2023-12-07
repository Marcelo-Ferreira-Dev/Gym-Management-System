package com.example.app.gymapi.dto;

import com.example.app.gymapi.abstracts.AbstractDto;
import lombok.Builder;
import lombok.Data;

@Data
public class ProductoDto extends AbstractDto {
    private String nombre;
    private String codigo;
    private String descripcion;
    private double precio;
    private int cantidad;
    private double iva;
    private double costoCompra;
    private boolean activo;
}
