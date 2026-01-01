package com.upc.proyecto.backendskillink.Repository;

import com.upc.proyecto.backendskillink.Entities.TemaAsesoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaAsesoriaRepository extends JpaRepository<TemaAsesoria, Long> {
    List<TemaAsesoria> findByVerAsesoria_Idverasesoria(Long idverasesoria);
}
