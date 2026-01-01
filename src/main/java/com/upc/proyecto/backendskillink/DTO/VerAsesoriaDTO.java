package com.upc.proyecto.backendskillink.DTO;

import com.upc.proyecto.backendskillink.Entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerAsesoriaDTO {

    private Long idverasesoria;
    private String descripcionVerAsesoria;  // corregido
    private Pago pago;
    private Asesoria asesoria;
    private List<TemaAsesoria> temasAsesoria; // la lista real de temas
    private List<ResenhaAsesoria> resenhas;
}
