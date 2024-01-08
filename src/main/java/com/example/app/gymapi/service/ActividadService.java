package com.example.app.gymapi.service;

import com.example.app.gymapi.bean.clientes.Actividad;
import com.example.app.gymapi.dao.ActividadDao;
import com.example.app.gymapi.dto.PageResponse;
import com.example.app.gymapi.dto.cliente.ActividadDto;
import com.example.app.gymapi.interfaces.IMapper;
import com.example.app.gymapi.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadService implements IService<ActividadDto> {

    @Autowired
    private ActividadDao dao;

    @Autowired
    private IMapper<Actividad, ActividadDto> mapper;

    @Override
    public ActividadDto create(ActividadDto dto) {
        Actividad actividad = mapper.toBean(dto, Actividad.class);
        dao.save(actividad);
        return mapper.toDto(actividad, ActividadDto.class);
    }

    @Override
    public ActividadDto getById(Long id) {
        var actividad = dao.findByIdAndActivoIsTrue(id);
        var actividadDto = mapper.toDto(actividad.get(), ActividadDto.class);
        return actividadDto;
    }

    @Override
    public PageResponse<ActividadDto> getAll(int page) {
        var actividades = dao.findByActivoIsTrueAndActivoIsTrue(page);
        var actividadesDto = actividades.map(actividad -> mapper.toDto(actividad, ActividadDto.class));
        var pagesResponse = new PageResponse<ActividadDto>(
                actividadesDto.getContent(),
                actividades.getTotalPages(),
                actividades.getTotalElements(),
                actividades.getNumber() + 1);
        return pagesResponse;
    }

    @Override
    public ActividadDto update(Long id, ActividadDto dto) {
        var actividad = dao.findByIdAndActivoIsTrue(id);

        if (dto.getNombre() != null) actividad.get().setNombre(dto.getNombre());
        if (dto.getDescripcion() != null) actividad.get().setDescripcion(dto.getDescripcion());
        if (dto.getCostoMensual() != null) actividad.get().setCostoMensual(dto.getCostoMensual());
        if (dto.getCostoSemanal() != null) actividad.get().setCostoSemanal(dto.getCostoSemanal());

        dao.save(actividad.get());

        return mapper.toDto(actividad.get(), ActividadDto.class);
    }

    @Override
    public boolean delete(Long id) {
        var actividad = dao.findByIdAndActivoIsTrue(id);
        if (actividad.isEmpty()) return false;
        actividad.get().setActivo(false);
        dao.save(actividad.get());
        return true;
    }

    @Override
    public PageResponse<ActividadDto> searchByNombre(String nombre, int page) {
        var actividades = dao.findByNombreContainingAndActivoIsTrue(nombre, page);
        var actividadesDto = actividades.map(actividad -> mapper.toDto(actividad, ActividadDto.class));
        var pagesResponse = new PageResponse<ActividadDto>(
                actividadesDto.getContent(),
                actividades.getTotalPages(),
                actividades.getTotalElements(),
                actividades.getNumber() + 1
        );
        return pagesResponse;
    }
}
