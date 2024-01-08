package com.example.app.gymapi.interfaces;

import com.example.app.gymapi.dto.PageResponse;
import com.example.app.gymapi.dto.cliente.MedicionDto;

public interface IClienteMedicionService extends IService<MedicionDto> {
    public MedicionDto create(Long clienteId, MedicionDto medicionDto);
    public PageResponse<MedicionDto> getAllByClienteId(Long clienteId, int page);
    public PageResponse<MedicionDto> getAll(Long clienteId, int page);
}
