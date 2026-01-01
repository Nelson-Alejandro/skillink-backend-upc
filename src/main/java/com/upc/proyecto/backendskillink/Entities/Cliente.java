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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcliente;

//    @Column(unique = true)
    private String nombrecliente;

    private String correocliente;
    @Digits(integer = 9, fraction = 0, message = "El teléfono debe tener hasta 9 dígitos")
    private int telefonocliente;
    private String direccioncliente;
    private Boolean estadocliente;
    @Column(nullable = false)
    private String password;

//    @ManyToOne
//    @JoinColumn(name = "idadministrador")
//    private Administrador administrador;
}
