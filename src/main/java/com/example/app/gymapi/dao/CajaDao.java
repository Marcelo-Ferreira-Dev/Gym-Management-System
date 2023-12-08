package com.example.app.gymapi.dao;

import com.example.app.gymapi.bean.caja.Caja;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CajaDao extends JpaRepository<Caja,Long> {

    Page<Caja> findAllByActivoIsTrue(Pageable pageable);
}
