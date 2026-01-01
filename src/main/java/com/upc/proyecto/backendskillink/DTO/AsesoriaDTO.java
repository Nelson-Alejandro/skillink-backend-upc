package com.upc.proyecto.backendskillink.DTO;

import com.upc.proyecto.backendskillink.Entities.Asesor;
import com.upc.proyecto.backendskillink.Entities.Cliente;
import jakarta.persistence.Column;
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
public class AsesoriaDTO {
    private Long idasesoria;
    private String nombreasesoria;
    private String descripcionasesoria;
    private Double costoasesoria;
    private LocalDate fechasesoria;
    private String urlimg;
    private String cantidadresenhas;
    private Integer cantidadestrellas;
    private Asesor asesor;
    private Cliente cliente;
}
