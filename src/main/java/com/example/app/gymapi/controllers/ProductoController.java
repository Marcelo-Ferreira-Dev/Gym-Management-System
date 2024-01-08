package com.example.app.gymapi.controllers;

import com.example.app.gymapi.dto.PageResponse;
import com.example.app.gymapi.dto.ProductoDto;
import com.example.app.gymapi.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    IService<ProductoDto> productoService;

    @PostMapping
    public ResponseEntity<ProductoDto> createProducto(@RequestBody ProductoDto productoDto) {
        try {
            ProductoDto createdProducto = productoService.create(productoDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProducto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/page/{page}")
    public ResponseEntity<PageResponse<ProductoDto>> getAllProductos(@PathVariable int page) {
        try {
            PageResponse<ProductoDto> productos = productoService.getAll(page);
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/search/{nombre}/page/{page}")
    public ResponseEntity<Map<String, Object>> searchProductosByNombre(@PathVariable String nombre,@PathVariable int page) {
        try {
            Page<ProductoDto> productos = productoService.searchByNombre(nombre,page);

            Map<String, Object> response = new HashMap<>();
            response.put("productos", productos.getContent()); // Agrega la lista de productos al mapa

            // Añadir información de paginación
            response.put("currentPage", productos.getNumber() + 1);
            response.put("totalItems", productos.getTotalElements());
            response.put("totalPages", productos.getTotalPages());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getProductoById(@PathVariable Long id) {
        try {
            ProductoDto producto = productoService.getById(id);

            if (producto != null) {
                return ResponseEntity.ok(producto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable Long id, @RequestBody ProductoDto productoDto) {
        try {
            ProductoDto updatedProducto = productoService.update(id, productoDto);

            if (updatedProducto != null) {
                return ResponseEntity.ok(updatedProducto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        try {
            boolean deleted = productoService.delete(id);

            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
