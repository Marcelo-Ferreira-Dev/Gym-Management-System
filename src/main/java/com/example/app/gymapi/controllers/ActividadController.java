package com.example.app.gymapi.controllers;

import com.example.app.gymapi.dto.PageResponse;
import com.example.app.gymapi.dto.cliente.ActividadDto;
import com.example.app.gymapi.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actividades")
public class ActividadController {
    @Autowired
    private IService<ActividadDto> service;

    public ResponseEntity<ActividadDto> create(ActividadDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    public ResponseEntity<ActividadDto> getById(Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    public ResponseEntity<PageResponse<ActividadDto>> getAll(int page) {
        return ResponseEntity.ok(service.getAll(page));
    }

    public ResponseEntity<ActividadDto> update(Long id, ActividadDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    public ResponseEntity<Boolean> delete(Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
