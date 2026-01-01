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
public class ClienteDTO {
    private Long idcliente;
    private String nombrecliente;
    private String correocliente;
    private int telefonocliente;
    private String direccioncliente;
    private Boolean estadocliente;
    private String password;
}
