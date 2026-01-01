package com.upc.proyecto.backendskillink.DTO;

import com.upc.proyecto.backendskillink.Entities.Asesoria;
import com.upc.proyecto.backendskillink.Entities.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResenhaAsesoriaDTO {
    private Long idresenha;
    private String descripcionresenha;
    private Integer puntajeresenha;
    private LocalDate fecharesenha;
    private Asesoria asesoria;
    private Cliente cliente;
}
