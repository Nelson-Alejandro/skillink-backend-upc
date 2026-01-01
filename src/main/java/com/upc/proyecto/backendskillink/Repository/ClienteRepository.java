package com.upc.proyecto.backendskillink.Repository;

import com.upc.proyecto.backendskillink.DTO.ClienteDTO;
import com.upc.proyecto.backendskillink.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByEstadocliente(Boolean estadocliente);
    Optional<Cliente> findByNombrecliente(String nombrecliente);
}