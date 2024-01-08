package com.example.app.gymapi.dao;

import com.example.app.gymapi.bean.clientes.Medicion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClienteMedicionDao extends JpaRepository<Medicion, Long> {
    Optional<Medicion> getByIdAndActivoIsTrue(Long clienteId);
    Page<Medicion> findByClienteIdAndActivoIsTrue(Pageable pageable, Long clienteId);
}
