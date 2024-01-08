package com.example.app.gymapi.dao;

import com.example.app.gymapi.bean.clientes.Actividad;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActividadDao extends JpaRepository<Actividad, Long> {
    Optional<Actividad> findByIdAndActivoIsTrue(Long id);
    Page<Actividad> findByNombreContainingAndActivoIsTrue(String nombre, int page);
    Page<Actividad> findByActivoIsTrueAndActivoIsTrue(int page);
}
