package com.upc.proyecto.backendskillink.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asesoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idasesoria;

    @Column(unique = true)
    private String nombreasesoria;
    private String descripcionasesoria;
    private Double costoasesoria;
    private LocalDate fechasesoria;
    private String urlimg;
    private String cantidadresenhas;
    private Integer cantidadestrellas;
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "idasesor")
    private Asesor asesor;
}
