package com.upc.proyecto.backendskillink.Controller;

import com.upc.proyecto.backendskillink.DTO.AsesoriaDTO;
import com.upc.proyecto.backendskillink.Service.AsesoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/skillink/asesoria")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AsesoriaController {
    @Autowired
    private AsesoriaService asesoriaService;


    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ASESOR')")

    public ResponseEntity<AsesoriaDTO> registrar(@Valid @RequestBody AsesoriaDTO asesoriaDTO) {
        AsesoriaDTO nuevaAsesoria = asesoriaService.registrar(asesoriaDTO);
        return ResponseEntity.ok(nuevaAsesoria);
    }


    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('ASESOR')")

    public ResponseEntity<AsesoriaDTO> actualizar(@Valid @RequestBody AsesoriaDTO asesoriaDTO) {
        AsesoriaDTO asesoriaActualizada = asesoriaService.actualizar(asesoriaDTO);
        return ResponseEntity.ok(asesoriaActualizada);
    }

    @GetMapping("/listar")
    public List<AsesoriaDTO> listarAsesorias() {
        return asesoriaService.listarasesoria();
    }
}
