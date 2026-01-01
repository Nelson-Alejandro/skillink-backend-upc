package com.upc.proyecto.backendskillink.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpago;

    private Double montopago;
    private String metodopago;
    private Boolean estadopago;
    private LocalDate fechapago;

    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;
}
