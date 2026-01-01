package com.upc.proyecto.backendskillink.Entities;

import com.upc.proyecto.backendskillink.DTO.AsesorDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idadministrador;
    @Column(unique = true)
    private String nombreadmin;
    private String correoadmin;
    @Digits(integer = 9, fraction = 0, message = "El teléfono debe tener hasta 9 dígitos")
    private int telefonoadmin;
    private String direccionadmin;
    private String password;

//    // Un administrador puede gestionar varios asesores
//    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
//    private List<Asesor> asesores;
//
//    // Un administrador puede gestionar varios clientes
//    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
//    private List<Cliente> clientes;
//
//    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
//    private List<Asesoria>  asesorias;
}
