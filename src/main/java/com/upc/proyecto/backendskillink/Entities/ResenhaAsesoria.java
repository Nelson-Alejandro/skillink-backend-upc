package com.upc.proyecto.backendskillink.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResenhaAsesoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idresenha;

    private String descripcionresenha;
    @Min(value = 0, message = "El valor minimo de resenha es 0")
    @Max(value = 5, message = "El valor maximo de resenha es 5")
    private Integer puntajeresenha;
    private LocalDate fecharesenha;
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_verasesoria")
    @JsonBackReference("resenhaRef")
    private VerAsesoria verAsesoria;


}
