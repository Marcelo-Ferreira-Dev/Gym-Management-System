package com.example.app.gymapi.bean.clientes;

import com.example.app.gymapi.abstracts.AbstractBean;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Cliente extends AbstractBean {
    @NotNull
    private String nombre;
    @NotNull
    private String cedula;
    @NotNull
    private String ruc;
    private String telefono;
    private String email;
    private String direccion;
    private LocalDate fecha_registro;
}
