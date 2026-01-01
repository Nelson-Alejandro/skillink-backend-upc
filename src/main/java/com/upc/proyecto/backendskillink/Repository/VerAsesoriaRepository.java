package com.upc.proyecto.backendskillink.Repository;

import com.upc.proyecto.backendskillink.Entities.VerAsesoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerAsesoriaRepository extends JpaRepository<VerAsesoria, Long> {
    List<VerAsesoria> findByAsesoria_Idasesoria(Long idasesoria);
}
