package com.example.app.gymapi.dao;

import com.example.app.gymapi.bean.caja.SesionCaja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionDao extends JpaRepository<SesionCaja,Long> {
}
