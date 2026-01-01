package com.upc.proyecto.backendskillink.Controller;

import com.upc.proyecto.backendskillink.DTO.VerAsesoriaDTO;
import com.upc.proyecto.backendskillink.Service.VerAsesoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillink/verasesoria")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VerAsesoriaController {

    @Autowired
    private VerAsesoriaService verAsesoriaService;


    @GetMapping("/listarverasesoria")
    public List<VerAsesoriaDTO> listarVerAsesorias() {
        return verAsesoriaService.listarVerAsesorias();
    }

    @GetMapping("/listarverasesoria/{idverasesoria}")
    public VerAsesoriaDTO obtenerVerAsesoriaPorId(@PathVariable Long idverasesoria) {
        return verAsesoriaService.obtenerVerAsesoriaPorId(idverasesoria);
    }

    @GetMapping("/asesoria/{idasesoria}")
    public VerAsesoriaDTO obtenerPorIdAsesoria(@PathVariable Long idasesoria) {
        return verAsesoriaService.obtenerPorIdAsesoria(idasesoria);
    }

}
