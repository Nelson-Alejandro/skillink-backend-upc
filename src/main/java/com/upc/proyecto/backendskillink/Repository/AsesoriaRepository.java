package com.upc.proyecto.backendskillink.Repository;

import com.upc.proyecto.backendskillink.DTO.AsesoriaDTO;
import com.upc.proyecto.backendskillink.Entities.Asesoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AsesoriaRepository extends JpaRepository<Asesoria, Long> {
    List<Asesoria> findByFechasesoria(LocalDate fechasesoria);

}
