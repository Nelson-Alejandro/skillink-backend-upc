package com.upc.proyecto.backendskillink.DTO;

import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorDTO {
    private Long idadministrador;
    private String nombreadmin;
    private String correoadmin;
    private int telefonoadmin;
    private String direccionadmin;
    private String password;
}
