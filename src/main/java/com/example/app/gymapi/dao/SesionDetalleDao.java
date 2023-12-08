package com.example.app.gymapi.dao;

import com.example.app.gymapi.bean.caja.SesionDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionDetalleDao extends JpaRepository<SesionDetalle,Long> {
}
