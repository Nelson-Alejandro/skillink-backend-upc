package com.upc.proyecto.backendskillink.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartillaAsesorDTO {
    private Long idcartillaasesor;
    private String nombrecartillaasesor;
    private String descripcioncartillaasesor;
    private String especialcartillaasesor;
    private Integer estrellascartillaasesor;
    private String urlcartillaasesor;
    private String anhoexperienciacartillaasesor;
    private Double preciocartillaasesor;
}
