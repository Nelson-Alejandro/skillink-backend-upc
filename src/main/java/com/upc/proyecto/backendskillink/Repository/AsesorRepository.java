package com.upc.proyecto.backendskillink.Repository;

import com.upc.proyecto.backendskillink.DTO.AsesorDTO;
import com.upc.proyecto.backendskillink.Entities.Asesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AsesorRepository extends JpaRepository<Asesor,Long> {
    List<Asesor> findByEstadoasesor(Boolean estadoasesor);
    List<Asesor> findByEspecialidadasesor(String especialidadasesor);
    Optional<Asesor> findFirstByEspecialidadasesor(String especialidadasesor);
    Optional<Asesor> findByNombreasesor(String nombreasesor);
}
