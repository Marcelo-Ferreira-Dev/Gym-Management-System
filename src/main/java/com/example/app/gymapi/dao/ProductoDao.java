package com.example.app.gymapi.dao;

import com.example.app.gymapi.bean.producto.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto,Long> {
    Page<Producto> findAllByActivoIsTrue(Pageable pageable);

    Page<Producto> findAllByActivoIsTrueAndNombreContaining(String nombre,Pageable pageable);
}
