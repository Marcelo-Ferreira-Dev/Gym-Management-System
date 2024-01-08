package com.example.app.gymapi.service;

import com.example.app.gymapi.bean.clientes.Cliente;
import com.example.app.gymapi.dao.ClienteDao;
import com.example.app.gymapi.dto.cliente.ClienteDto;
import com.example.app.gymapi.dto.PageResponse;
import com.example.app.gymapi.exceptions.NotFoundException;
import com.example.app.gymapi.interfaces.IClienteService;
import com.example.app.gymapi.interfaces.IMapper;
import com.example.app.gymapi.utils.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Autowired
    private IMapper<Cliente, ClienteDto> mapper;

    @Override
    @Async
    public ClienteDto create(ClienteDto dto) {
        var cliente = mapper.toBean(dto, Cliente.class);
        cliente.setActivo(true);
        clienteDao.save(cliente);
        return mapper.toDto(cliente, ClienteDto.class);
    }

    @Override
    public ClienteDto getById(Long id) {
        var cliente = clienteDao.findByIdAndActivoIsTrue(id);
        if (cliente.isPresent()) {
            return mapper.toDto(cliente.get(), ClienteDto.class);
        }
        throw new NotFoundException("Cliente no encontrado");
    }

    @Override
    public PageResponse<ClienteDto> getAll(int page) {
        var pag = PageRequest.of(page - 1, Setting.PAGE_SIZE);
        var clientes = clienteDao.findAllByActivoIsTrue(pag);

        if (clientes.isEmpty()) {
            throw new NotFoundException("No hay clientes en la lista");
        }

        var clientesDto = clientes.map(cliente -> mapper.toDto(cliente, ClienteDto.class));
        var pageResponse = new PageResponse<ClienteDto>(clientesDto.getContent(),
                clientesDto.getTotalPages(),
                clientesDto.getTotalElements(),
                clientesDto.getNumber() + 1);
        return pageResponse;
    }

    @Override
    public ClienteDto update(Long id, ClienteDto dto) {
        var cliente = clienteDao.findByIdAndActivoIsTrue(id);
        if (cliente.isPresent()) {
            var clienteBean = cliente.get();

            if (dto.getNombre() != null) clienteBean.setNombre(dto.getNombre());
            if (dto.getCedula() != null) clienteBean.setCedula(dto.getCedula());
            if (dto.getRuc() != null) clienteBean.setRuc(dto.getRuc());
            if (dto.getTelefono() != null) clienteBean.setTelefono(dto.getTelefono());
            if (dto.getEmail() != null) clienteBean.setEmail(dto.getEmail());
            if (dto.getDireccion() != null) clienteBean.setDireccion(dto.getDireccion());

            clienteDao.save(clienteBean);

            return mapper.toDto(clienteBean, ClienteDto.class);
        }
        throw new NotFoundException("Cliente no encontrado");
    }

    @Override
    public boolean delete(Long id) {
        var cliente = clienteDao.findByIdAndActivoIsTrue(id);
        if (cliente.isPresent()) {
            var clienteBean = cliente.get();
            clienteBean.setActivo(false);
            clienteDao.save(clienteBean);
            return true;
        }
        throw new NotFoundException("Cliente no encontrado");
    }

    @Override
    public PageResponse<ClienteDto> searchByNombre(String nombre, int page) {
        var pag = PageRequest.of(page - 1, Setting.PAGE_SIZE);
        var clientes = clienteDao.findByNombreAndActivoIsTrue(pag, nombre);

        if (clientes.isEmpty()) {
            throw new NotFoundException("No hay clientes en la lista");
        }

        var clientesDto = clientes.map(cliente -> mapper.toDto(cliente, ClienteDto.class));
        var pageResponse = new PageResponse<ClienteDto>(
                clientesDto.getContent(),
                clientesDto.getTotalPages(),
                clientesDto.getTotalElements(),
                clientesDto.getNumber() + 1);
        return pageResponse;
    }

    @Override
    public PageResponse<ClienteDto> searchByCi(String ci, int page) {
        var pag = PageRequest.of(page - 1, Setting.PAGE_SIZE);
        var clientes = clienteDao.findByCedulaAndActivoIsTrue(pag, ci);

        if(clientes.isEmpty()){
            throw new NotFoundException("No hay clientes con esa cedula");
        }

        var clientesDto = clientes.map(cliente -> mapper.toDto(cliente, ClienteDto.class));
        var pageResponse = new PageResponse<ClienteDto>(
                clientesDto.getContent(),
                clientesDto.getTotalPages(),
                clientesDto.getTotalElements(),
                clientesDto.getNumber() + 1);

        return pageResponse;
    }
}
