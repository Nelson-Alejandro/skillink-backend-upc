package com.upc.proyecto.backendskillink.Repository;

import com.upc.proyecto.backendskillink.Entities.CartillaAsesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartillaAsesorRepository extends JpaRepository<CartillaAsesor, Long> {
    List<CartillaAsesor> findByEstrellascartillaasesor(Integer estrellas);
    List<CartillaAsesor> findAllByOrderByPreciocartillaasesorAsc();
    List<CartillaAsesor> findAllByOrderByAnhoexperienciacartillaasesorDesc();

}
