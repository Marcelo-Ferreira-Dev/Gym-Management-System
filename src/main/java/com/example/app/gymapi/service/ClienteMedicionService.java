package com.example.app.gymapi.service;

import com.example.app.gymapi.bean.clientes.Medicion;
import com.example.app.gymapi.dao.ClienteMedicionDao;
import com.example.app.gymapi.dto.PageResponse;
import com.example.app.gymapi.dto.cliente.MedicionDto;
import com.example.app.gymapi.exceptions.NotFoundException;
import com.example.app.gymapi.interfaces.IClienteMedicionService;
import com.example.app.gymapi.interfaces.IMapper;
import com.example.app.gymapi.utils.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteMedicionService implements IClienteMedicionService {

    @Autowired
    private ClienteMedicionDao clienteMedicionDao;


    @Autowired
    private IMapper<Medicion, MedicionDto> mapper;

    @Override
    public MedicionDto create(Long clienteId, MedicionDto medicionDto) {
        medicionDto.setClienteId(clienteId);
        var medicion = mapper.toBean(medicionDto, Medicion.class);
        medicion.setActivo(true);
        return mapper.toDto(clienteMedicionDao.save(medicion), MedicionDto.class);
    }

    @Override
    public MedicionDto create(MedicionDto dto) {
        // NO IMPLEMENTADO
        return null;
    }


    @Override
    public MedicionDto getById(Long id) {
        var medicion = clienteMedicionDao.getByIdAndActivoIsTrue(id);
        if (!medicion.isPresent()) throw new NotFoundException("Medicion no encontrada");
        return mapper.toDto(medicion.get(), MedicionDto.class);
    }

    @Override
    public PageResponse<MedicionDto> getAllByClienteId(Long clienteId, int page) {
        Pageable pageable = PageRequest.of(page - 1, Setting.PAGE_SIZE);
        var mediciones = clienteMedicionDao.findByClienteIdAndActivoIsTrue(pageable, clienteId);
        var medicionesDto = mediciones.map(medicion -> mapper.toDto(medicion, MedicionDto.class));
        PageResponse<MedicionDto> pageResponse = new PageResponse<>(
                medicionesDto.getContent(),
                medicionesDto.getTotalPages(),
                medicionesDto.getTotalElements(),
                medicionesDto.getNumber() + 1
        );
        return pageResponse;
    }

    @Override
    public PageResponse<MedicionDto> getAll(int page) {
        // NO IMPLEMENTADO
        return null;
    }

    @Override
    public PageResponse<MedicionDto> getAll(Long clienteId, int page) {
        var pageable = PageRequest.of(page - 1, Setting.PAGE_SIZE);
        var mediciones = clienteMedicionDao.findByClienteIdAndActivoIsTrue(pageable, clienteId);
        var medicionesDto = mediciones.map(medicion -> mapper.toDto(medicion, MedicionDto.class));
        PageResponse<MedicionDto> pageResponse = new PageResponse<>(
                medicionesDto.getContent(),
                medicionesDto.getTotalPages(),
                medicionesDto.getTotalElements(),
                medicionesDto.getNumber() + 1
        );
        return pageResponse;
    }

    @Override
    public MedicionDto update(Long id, MedicionDto dto) {
        var medicion = clienteMedicionDao.getByIdAndActivoIsTrue(id);
        if (!medicion.isPresent()) throw new NotFoundException("Medicion no encontrada");

        if(dto.getPeso()!=null) medicion.get().setPeso(dto.getPeso());
        if(dto.getAltura()!=null) medicion.get().setAltura(dto.getAltura());
        if(dto.getImc()!=null) medicion.get().setImc(dto.getImc());
        if(dto.getFecha()!=null) medicion.get().setFecha(dto.getFecha());

        return mapper.toDto(clienteMedicionDao.save(medicion.get()), MedicionDto.class);
    }

    @Override
    public boolean delete(Long id) {
        var medicion = clienteMedicionDao.getByIdAndActivoIsTrue(id);
        if (!medicion.isPresent()) throw new NotFoundException("Medicion no encontrada");
        medicion.get().setActivo(false);
        clienteMedicionDao.save(medicion.get());
        return true;
    }

    @Override
    public PageResponse<MedicionDto> searchByNombre(String nombre, int page) {
        // NO IMPLEMENTADO
        return null;
    }
}
