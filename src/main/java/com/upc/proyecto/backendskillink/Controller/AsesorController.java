package com.upc.proyecto.backendskillink.Controller;

import com.upc.proyecto.backendskillink.DTO.AsesorDTO;
import com.upc.proyecto.backendskillink.DTO.AsesoriaDTO;
import com.upc.proyecto.backendskillink.Service.AsesorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillink/asesor")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AsesorController {
    @Autowired
    private final AsesorService asesorService;

    @PostMapping("/registrar")
    public ResponseEntity<AsesorDTO> registrar(@RequestBody AsesorDTO asesorDTO) {
        AsesorDTO nuevoAsesor = asesorService.registrar(asesorDTO);
        return ResponseEntity.ok(nuevoAsesor);
    }

    @PutMapping("/actualizar")

    public ResponseEntity<AsesorDTO> actualizar(@Valid @RequestBody AsesorDTO asesorDTO) {
        AsesorDTO asesorActualizado = asesorService.actualizar(asesorDTO);
        return ResponseEntity.ok(asesorActualizado);
    }

    @GetMapping("/listar")
    public List<AsesorDTO> listarAsesores() {
        return asesorService.listarasesor();
    }

}
