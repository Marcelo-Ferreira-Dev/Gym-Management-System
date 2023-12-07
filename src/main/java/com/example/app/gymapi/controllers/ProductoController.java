package com.example.app.gymapi.controllers;

import com.example.app.gymapi.bean.producto.Producto;
import com.example.app.gymapi.dto.ProductoDto;
import com.example.app.gymapi.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    IService<ProductoDto> service;
    @PostMapping
    public ProductoDto crear(){
        ProductoDto productoDto = ProductoDto.builder()
                .nombre("Pepa")
                .codigo("1234")
                .descripcion("algo")
                .precio(5000)
                .build();

        return service.create(productoDto);

    }

}
