package com.upc.proyecto.backendskillink.Controller;


import com.upc.proyecto.backendskillink.DTO.ResenhaAsesorDTO;
import com.upc.proyecto.backendskillink.Service.ResenhaAsesorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/skillink/resenha-asesor")
public class ResenhaAsesorController {
    @Autowired
    private ResenhaAsesorService resenhaAsesorService;

    @PostMapping("/registrar")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<ResenhaAsesorDTO> registrar(@Valid @RequestBody ResenhaAsesorDTO resenhaAsesorDTO) {
        ResenhaAsesorDTO nuevaResenha = resenhaAsesorService.registrar(resenhaAsesorDTO);
        return ResponseEntity.ok(nuevaResenha);
    }


    @PutMapping("/actualizar")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<ResenhaAsesorDTO> actualizar(@Valid @RequestBody ResenhaAsesorDTO resenhaAsesorDTO) {
        ResenhaAsesorDTO resenhaActualizada = resenhaAsesorService.actualizar(resenhaAsesorDTO);
        return ResponseEntity.ok(resenhaActualizada);
    }


    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<ResenhaAsesorDTO> buscarPorId(@PathVariable("id") Long idresenha) {
        ResenhaAsesorDTO resenha = resenhaAsesorService.findByIdresenha(idresenha);
        return ResponseEntity.ok(resenha);
    }


    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long idresenha) {
        resenhaAsesorService.eliminar(idresenha);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/listar")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<List<ResenhaAsesorDTO>> listar() {
        List<ResenhaAsesorDTO> lista = resenhaAsesorService.listar();
        return ResponseEntity.ok(lista);
    }


    @GetMapping("/listar/puntaje/{puntaje}")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<List<ResenhaAsesorDTO>> listarPorPuntaje(@PathVariable("puntaje") Integer puntajeresenha) {
        List<ResenhaAsesorDTO> lista = resenhaAsesorService.findByPuntajeresenha(puntajeresenha);
        return ResponseEntity.ok(lista);
    }


    @GetMapping("/listar/fecha/{fecha}")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<List<ResenhaAsesorDTO>> listarPorFecha(@PathVariable("fecha") LocalDate fecharesenha) {
        List<ResenhaAsesorDTO> lista = resenhaAsesorService.listarporfecharesenha(fecharesenha);
        return ResponseEntity.ok(lista);
    }
}
