package com.example.app.gymapi.service;

import com.example.app.gymapi.bean.caja.Caja;
import com.example.app.gymapi.dao.CajaDao;
import com.example.app.gymapi.dto.CajaDto;
import com.example.app.gymapi.dto.PageResponse;
import com.example.app.gymapi.interfaces.IMapper;
import com.example.app.gymapi.interfaces.IService;
import com.example.app.gymapi.utils.Setting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CajaService implements IService<CajaDto> {
    private final Logger logger = LoggerFactory.getLogger(CajaService.class);

    @Autowired
    private IMapper<Caja, CajaDto> mapper;
    @Autowired
    private CajaDao cajaDao;

    @Override
    @Transactional
    public CajaDto create(CajaDto dto) {
        try {
            Caja cajaBean = mapper.toBean(dto, Caja.class);
            cajaDao.save(cajaBean);
            logger.info("Caja creada");
            return mapper.toDto(cajaBean, CajaDto.class);
        } catch (Exception e) {
            logger.error("Error al crear la caja", e);
            throw e;
        }
    }


    @Override
    @Transactional
    public CajaDto getById(Long id) {
        try {
            Optional<Caja> optionalCaja = cajaDao.findById(id);
            if (optionalCaja.isPresent() && optionalCaja.get().isActivo()) {
                return mapper.toDto(optionalCaja.get(), CajaDto.class);
            }
            return null; // Caja no encontrada o no activa
        } catch (Exception e) {
            logger.error("Error al obtener la caja", e);
            throw e;
        }
    }

    @Override
    @Transactional
    public PageResponse<CajaDto> getAll(int page) {
        Pageable pageable = PageRequest.of(page - 1, Setting.PAGE_SIZE);
        Page<Caja> cajasActivas = cajaDao.findAllByActivoIsTrue(pageable);

        Page<CajaDto> cajasDto = cajasActivas.map(caja -> mapper.toDto(caja, CajaDto.class));

        PageResponse<CajaDto> pageResponse = new PageResponse<>(cajasDto.getContent(),
                cajasDto.getTotalPages(),
                cajasDto.getTotalElements(),
                cajasDto.getNumber() + 1);

        return pageResponse;
    }

    @Override
    @Transactional
    public CajaDto update(Long id, CajaDto cajaDto) {
        try {
            Optional<Caja> optionalCaja = cajaDao.findById(id);
            if (optionalCaja.isPresent()) {
                Caja caja = mapper.toBean(cajaDto, Caja.class);
                caja.setId(id);
                cajaDao.save(caja);
                return mapper.toDto(caja, CajaDto.class);
            }
            return null; // Caja no encontrada
        } catch (Exception e) {
            logger.error("Error al actualizar la caja", e);
            throw e;
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        try {
            Optional<Caja> optionalCaja = cajaDao.findById(id);
            if (optionalCaja.isPresent()) {
                Caja caja = optionalCaja.get();
                caja.setActivo(false); // Borrado lógico
                cajaDao.save(caja);
                return true;
            }
            return false; // Caja no encontrada
        } catch (Exception e) {
            logger.error("Error al cerrar la caja", e);
            throw e;
        }
    }

    /**
     * @param nombre
     * @param page
     * @return
     */
    @Override
    public PageResponse<CajaDto> searchByNombre(String nombre, int page) {
        return null;
    }
}
