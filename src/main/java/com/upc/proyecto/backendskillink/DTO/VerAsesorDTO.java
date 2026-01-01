package com.upc.proyecto.backendskillink.DTO;

import com.upc.proyecto.backendskillink.Entities.CartillaAsesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerAsesorDTO {
  private Long idverasesor;
  private String descripcionverasesor;
  private CartillaAsesor cartillaAsesor;
}
