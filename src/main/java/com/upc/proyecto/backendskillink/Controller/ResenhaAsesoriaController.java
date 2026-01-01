package com.upc.proyecto.backendskillink.Controller;

import com.upc.proyecto.backendskillink.DTO.ResenhaAsesoriaDTO;
import com.upc.proyecto.backendskillink.Service.ResenhaAsesoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/skillink/resenha-asesoria")
public class ResenhaAsesoriaController {
    @Autowired
    private ResenhaAsesoriaService resenhaAsesoriaService;

    @PostMapping("/registrar")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<ResenhaAsesoriaDTO> registrar(@Valid @RequestBody ResenhaAsesoriaDTO resenhaAsesoriaDTO) {
        ResenhaAsesoriaDTO nuevaResenha = resenhaAsesoriaService.registrar(resenhaAsesoriaDTO);
        return ResponseEntity.ok(nuevaResenha);
    }


    @PutMapping("/actualizar")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<ResenhaAsesoriaDTO> actualizar(@Valid @RequestBody ResenhaAsesoriaDTO resenhaAsesoriaDTO) {
        ResenhaAsesoriaDTO resenhaActualizada = resenhaAsesoriaService.actualizar(resenhaAsesoriaDTO);
        return ResponseEntity.ok(resenhaActualizada);
    }


    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<ResenhaAsesoriaDTO> buscarPorId(@PathVariable("id") Long idresenha) {
        ResenhaAsesoriaDTO resenha = resenhaAsesoriaService.findByIdresenha(idresenha);
        return ResponseEntity.ok(resenha);
    }


    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long idresenha) {
        resenhaAsesoriaService.eliminar(idresenha);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/listar")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<List<ResenhaAsesoriaDTO>> listar() {
        List<ResenhaAsesoriaDTO> lista = resenhaAsesoriaService.listar();
        return ResponseEntity.ok(lista);
    }


    @GetMapping("/listar/puntaje/{puntaje}")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<List<ResenhaAsesoriaDTO>> listarPorPuntaje(@PathVariable("puntaje") Integer puntajeresenha) {
        List<ResenhaAsesoriaDTO> lista = resenhaAsesoriaService.findByPuntajeresenha(puntajeresenha);
        return ResponseEntity.ok(lista);
    }


    @GetMapping("/listar/fecha/{fecha}")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<List<ResenhaAsesoriaDTO>> listarPorFecha(@PathVariable("fecha") LocalDate fecharesenha) {
        List<ResenhaAsesoriaDTO> lista = resenhaAsesoriaService.listarporfecharesenha(fecharesenha);
        return ResponseEntity.ok(lista);
    }
}
