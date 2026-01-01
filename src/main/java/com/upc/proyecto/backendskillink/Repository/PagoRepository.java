package com.upc.proyecto.backendskillink.Repository;

import com.upc.proyecto.backendskillink.DTO.PagoDTO;
import com.upc.proyecto.backendskillink.Entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PagoRepository extends JpaRepository<Pago,Long> {
    List<Pago> findByFechapago(LocalDate fechapago);
    List<Pago> findByEstadopago(Boolean estadopago);
}
