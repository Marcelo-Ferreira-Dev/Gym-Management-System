package com.example.app.gymapi.bean.clientes;

import com.example.app.gymapi.abstracts.AbstractBean;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity()
@Data
public class Cliente extends AbstractBean {
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique = true)
    private String cedula;
    @NotNull
    @Column(unique = true)
    private String ruc;
    private String telefono;
    private String email;
    private String direccion;
    private LocalDate fechaRegistro;
}
