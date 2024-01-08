package com.example.app.gymapi.controllers;

import com.example.app.gymapi.dto.cliente.ClienteDto;
import com.example.app.gymapi.dto.PageResponse;
import com.example.app.gymapi.dto.cliente.UpdateClienteDto;
import com.example.app.gymapi.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;
    @PostMapping
    public ResponseEntity<ClienteDto> create(@RequestBody ClienteDto clienteDto) {
        return new ResponseEntity<>(clienteService.create(clienteDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(clienteService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/page/{page}")
    public ResponseEntity<PageResponse<ClienteDto>> getAll(@PathVariable int page) {
        return new ResponseEntity<>(clienteService.getAll(page), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> update(@PathVariable Long id, @RequestBody UpdateClienteDto clienteDto) {
        return new ResponseEntity<>(clienteService.update(id, clienteDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(clienteService.delete(id), HttpStatus.OK);
    }

}
