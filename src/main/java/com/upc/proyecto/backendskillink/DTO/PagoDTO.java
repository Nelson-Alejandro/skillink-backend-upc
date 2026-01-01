package com.upc.proyecto.backendskillink.DTO;

import com.upc.proyecto.backendskillink.Entities.Cliente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {
    private Long idpago;
    private Double montopago;
    private String metodopago;
    private Boolean estadopago;
    private LocalDate fechapago;
    private Cliente cliente;

}
