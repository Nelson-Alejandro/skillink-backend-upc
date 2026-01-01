package com.upc.proyecto.backendskillink.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartillaAsesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcartillaasesor;
    private String nombrecartillaasesor;
    private String descripcioncartillaasesor;
    private String especialcartillaasesor;
    private Integer estrellascartillaasesor;
    private String urlcartillaasesor;
    private String anhoexperienciacartillaasesor;
    private Double preciocartillaasesor;
}
