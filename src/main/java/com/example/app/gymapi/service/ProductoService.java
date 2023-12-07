package com.example.app.gymapi.service;

import com.example.app.gymapi.bean.producto.Producto;
import com.example.app.gymapi.dto.ProductoDto;
import com.example.app.gymapi.interfaces.IMapper;
import com.example.app.gymapi.interfaces.IService;
import com.example.app.gymapi.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IService<ProductoDto> {
    @Autowired
    private IMapper<Producto,ProductoDto> mapper;

    /**
     * @param dto
     * @return
     */
    @Override
    public ProductoDto create(ProductoDto dto) {
        System.out.println(mapper.toBean(dto));
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
