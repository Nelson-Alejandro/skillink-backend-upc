package com.upc.proyecto.backendskillink.Repository;

import com.upc.proyecto.backendskillink.DTO.ResenhaAsesoriaDTO;
import com.upc.proyecto.backendskillink.Entities.ResenhaAsesoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface ResenhaAsesoriaRepository extends JpaRepository<ResenhaAsesoria,Long> {
    List<ResenhaAsesoria> findByPuntajeresenha(Integer puntajeresenha);
    List<ResenhaAsesoria> findByFecharesenha(LocalDate fecharesenha);


}
