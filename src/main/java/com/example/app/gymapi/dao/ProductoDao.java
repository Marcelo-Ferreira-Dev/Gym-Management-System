package com.example.app.gymapi.dao;

import com.example.app.gymapi.bean.producto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto,Long> {


}
