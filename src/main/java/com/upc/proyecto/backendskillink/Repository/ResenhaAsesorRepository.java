package com.upc.proyecto.backendskillink.Repository;

import com.upc.proyecto.backendskillink.DTO.ResenhaAsesorDTO;
import com.upc.proyecto.backendskillink.Entities.ResenhaAsesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ResenhaAsesorRepository extends JpaRepository<ResenhaAsesor,Long> {
    List<ResenhaAsesor> findByPuntajeresenha(Integer puntajeresenha);
    List<ResenhaAsesor> findByFecharesenha(LocalDate fecharesenha);

}
