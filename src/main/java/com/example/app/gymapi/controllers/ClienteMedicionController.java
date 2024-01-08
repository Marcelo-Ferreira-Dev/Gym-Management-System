package com.example.app.gymapi.controllers;

import com.example.app.gymapi.dto.PageResponse;
import com.example.app.gymapi.dto.cliente.MedicionDto;
import com.example.app.gymapi.interfaces.IClienteMedicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes/{clienteId}/mediciones")
public class ClienteMedicionController {

    @Autowired
    private IClienteMedicionService clienteMedicionService;

    @PostMapping
    public ResponseEntity<MedicionDto> create(@PathVariable Long clienteId, @RequestBody MedicionDto medicionDto) {
        return ResponseEntity.ok(clienteMedicionService.create(clienteId, medicionDto));
    }

    @GetMapping("/page/{page}")
    public ResponseEntity<PageResponse<MedicionDto>> getAll(@PathVariable Long clienteId, @PathVariable int page){
        return ResponseEntity.ok(clienteMedicionService.getAllByClienteId(clienteId, page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicionDto> getById(@PathVariable Long clienteId, @PathVariable Long id){
        return ResponseEntity.ok(clienteMedicionService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicionDto> update(@PathVariable Long clienteId, @PathVariable Long id, @RequestBody MedicionDto medicionDto){
        return ResponseEntity.ok(clienteMedicionService.update(id, medicionDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long clienteId, @PathVariable Long id){
        return ResponseEntity.ok(clienteMedicionService.delete(id));
    }

}
