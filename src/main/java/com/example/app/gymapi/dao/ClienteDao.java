package com.example.app.gymapi.dao;

import com.example.app.gymapi.bean.clientes.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
    public Cliente findAllByActivoIsTrue(String email);
    public Cliente findByEmailAndActivoIsTrue(Pageable pag, String email);
    public Cliente findByCedulaAndActivoIsTrue(String cedula);
    public Cliente findByRucAndActivoIsTrue(Pageable pag, String ruc);
}