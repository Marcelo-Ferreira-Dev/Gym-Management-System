package com.example.app.gymapi.service;

import com.example.app.gymapi.bean.producto.Producto;
import com.example.app.gymapi.dao.ProductoDao;
import com.example.app.gymapi.dto.ProductoDto;
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
public class ProductoService implements IService<ProductoDto> {
    private final Logger logger = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    private IMapper<Producto,ProductoDto> mapper;
    @Autowired
    private ProductoDao productoDao;

    /**
     * @param dto
     * @return
     */
    @Override
    public ProductoDto create(ProductoDto dto) {
        try {
            Producto productoBean= mapper.toBean(dto,Producto.class);
            productoDao.save(productoBean);
            logger.info("Producto Creado");
            return mapper.toDto(productoBean, ProductoDto.class);
        } catch (Exception e) {
            logger.error("Error al crear el producto", e);
            throw e;
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    @Transactional
    public ProductoDto getById(Long id) {
        try {
            Optional<Producto> optionalProducto = productoDao.findById(id);
            if (optionalProducto.isPresent() && optionalProducto.get().isActivo()) {
                return mapper.toDto(optionalProducto.get(), ProductoDto.class);
            }
            return null; // Producto no encontrado o no activo
        } catch (Exception e) {
            logger.error("Error al obtener el producto", e);
            throw e;
        }
    }

    /**
     * @param page
     * @return
     */
    @Override
    @Transactional
    public Page<ProductoDto> getAll(int page) {
        Pageable pageable = PageRequest.of(page - 1, Setting.PAGE_SIZE);
        Page<Producto> productosActivos = productoDao.findAllByActivoIsTrue(pageable);

        Page<ProductoDto> productoDtoList = productosActivos.map(producto -> mapper.toDto(producto, ProductoDto.class) );

        // Cachear manualmente cada producto en Redis
//        for (ProductoDto productoDto : productoDtoList) {
//            String cacheName = "sd::api_productos";
//            String key = "producto_" + productoDto.getId();
//            Cache cache = cacheManager.getCache(cacheName);
//
//            // Verificar si el producto ya está en la caché
//            Cache.ValueWrapper valueWrapper = cache.get(key);
//
//            if (valueWrapper == null) {
//                // Si no está en la caché, cachearlo
//                cache.put(key, productoDto);
//            }
//        }

        return productoDtoList;
    }
    @Transactional
    @Override
    public Page<ProductoDto> searchByNombre(String nombre,int page) {
        Pageable pageable = PageRequest.of(page - 1, Setting.PAGE_SIZE);
        Page<Producto> productosActivos = productoDao.findAllByActivoIsTrueAndNombreContaining(nombre,pageable);

        Page<ProductoDto> productoDtoList = productosActivos.map(producto -> mapper.toDto(producto, ProductoDto.class) );

        // Cachear manualmente cada producto en Redis
//        for (ProductoDto productoDto : productoDtoList) {
//            String cacheName = "sd::api_productos";
//            String key = "producto_" + productoDto.getId();
//            Cache cache = cacheManager.getCache(cacheName);
//
//            // Verificar si el producto ya está en la caché
//            Cache.ValueWrapper valueWrapper = cache.get(key);
//
//            if (valueWrapper == null) {
//                // Si no está en la caché, cachearlo
//                cache.put(key, productoDto);
//            }
//        }

        return productoDtoList;
    }

    /**
     * @param id
     * @param productoDto
     * @return
     */
    @Override
    @Transactional
    public ProductoDto update(Long id, ProductoDto productoDto) {
        try {
            Optional<Producto> optionalProducto = productoDao.findById(id);
            if (optionalProducto.isPresent()) {
                Producto producto = mapper.toBean(productoDto,Producto.class);
                producto.setId(id);
                productoDao.save(producto);
                return mapper.toDto(producto,ProductoDto.class);
            }
            return null; // Producto no encontrado
        } catch (Exception e) {
            logger.error("Error al actualizar el producto", e);
            throw e;
        }
    }


    /**
     * @param id
     * @return
     */
    @Override
    @Transactional
    public boolean delete(Long id) {
        try {
            Optional<Producto> optionalProducto = productoDao.findById(id);
            if (optionalProducto.isPresent()) {
                Producto producto = optionalProducto.get();
                producto.setActivo(false); // Borrado lógico
                productoDao.save(producto);
                return true;
            }
            return false; // Producto no encontrado
        } catch (Exception e) {
            logger.error("Error al eliminar el producto", e);
            throw e;
        }
    }
}
