package com.example.app.gymapi.dao;

import com.example.app.gymapi.bean.clientes.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long> {
    public Optional<Cliente> findByIdAndActivoIsTrue(Long id);
    public Page<Cliente> findByNombreAndActivoIsTrue(Pageable pag, String cedula);
    public Page<Cliente> findAllByActivoIsTrue(Pageable pag);
    public Page<Cliente> findAllByActivoIsTrue(Pageable pag, String email);
    public Page<Cliente> findByEmailAndActivoIsTrue(Pageable pag, String email);
    public Page<Cliente> findByCedulaAndActivoIsTrue(Pageable pageable, String cedula);
    public Page<Cliente> findByRucAndActivoIsTrue(Pageable pag, String ruc);
}