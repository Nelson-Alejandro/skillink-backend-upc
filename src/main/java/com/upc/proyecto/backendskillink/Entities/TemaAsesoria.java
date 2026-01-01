package com.upc.proyecto.backendskillink.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TemaAsesoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtema;
    private String nombreTema;
    private String descripcionTema;
    @ManyToOne
    @JoinColumn(name = "idverasesoria")
    @JsonBackReference
    private VerAsesoria verAsesoria;

}
