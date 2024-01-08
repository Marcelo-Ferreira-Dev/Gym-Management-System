package com.example.app.gymapi.interfaces;

import com.example.app.gymapi.dto.PageResponse;
import com.example.app.gymapi.dto.cliente.ClienteDto;

public interface IClienteService extends IService<ClienteDto>{
    PageResponse<ClienteDto> searchByNombre(String nombre, int page);
    PageResponse<ClienteDto> searchByCi(String ci, int page);

}