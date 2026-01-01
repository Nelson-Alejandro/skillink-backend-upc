package com.upc.proyecto.backendskillink.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerAsesor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idverasesor;
  private String descripcionverasesor;

  @ManyToOne
  @JoinColumn(name = "asesor")
  private CartillaAsesor cartillaAsesor;



}
