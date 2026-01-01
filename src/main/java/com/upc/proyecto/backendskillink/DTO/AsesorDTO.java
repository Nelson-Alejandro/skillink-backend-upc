package com.upc.proyecto.backendskillink.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsesorDTO {
    private Long idasesor;
    private String nombreasesor;
    private String correoasesor;
    private int telefonoasesor;
    private String direccionasesor;
    private Boolean estadoasesor;
    private String especialidadasesor;
    private String password;
}
