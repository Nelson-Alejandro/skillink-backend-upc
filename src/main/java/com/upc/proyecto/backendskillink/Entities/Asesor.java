package com.upc.proyecto.backendskillink.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idasesor;

    @Column(unique = true)
    private String nombreasesor;

    private String correoasesor;
    @Digits(integer = 9, fraction = 0, message = "El teléfono debe tener hasta 9 dígitos")
    private int telefonoasesor;
    private String direccionasesor;
    private Boolean estadoasesor;
    private String especialidadasesor;
    private String password;

//    @ManyToOne
//    @JoinColumn(name = "idadministrador")
//    private Administrador administrador;
}
