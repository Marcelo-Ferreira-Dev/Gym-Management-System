package com.example.app.gymapi.service;

import com.example.app.gymapi.dto.ProductoDto;
import com.example.app.gymapi.interfaces.IService;
import org.springframework.data.domain.Page;

public class ProductoService implements IService<ProductoDto> {
    /**
     * @param dto
     * @return
     */
    @Override
    public ProductoDto create(ProductoDto dto) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ProductoDto getById(Long id) {
        return null;
    }

    /**
     * @param page
     * @return
     */
    @Override
    public Page<ProductoDto> getAll(int page) {
        return null;
    }

    /**
     * @param id
     * @param dto
     * @return
     */
    @Override
    public ProductoDto update(Long id, ProductoDto dto) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean delete(Long id) {
        return false;
    }
}
