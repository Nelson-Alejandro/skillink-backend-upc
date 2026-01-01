package com.upc.proyecto.backendskillink.DTO;

import com.upc.proyecto.backendskillink.Entities.VerAsesoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TemaAsesoriaDTO {

    private Long idtema;
    private String nombreTema;
    private String descripcionTema;
    private Long idverasesoria;

}
