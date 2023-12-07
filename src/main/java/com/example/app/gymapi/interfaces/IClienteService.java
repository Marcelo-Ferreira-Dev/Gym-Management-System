package com.example.app.gymapi.interfaces;

import com.example.app.gymapi.bean.clientes.Cliente;
import com.example.app.gymapi.dto.ClienteDto;
import org.springframework.data.domain.Page;

public interface IClienteService extends IService<ClienteDto>{
    Page<ClienteDto> searchByNombre(String nombre, int page);
    Page<ClienteDto> searchByCi(String ci, int page);
}