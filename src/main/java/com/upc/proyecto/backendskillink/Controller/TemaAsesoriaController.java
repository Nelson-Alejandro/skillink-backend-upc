package com.upc.proyecto.backendskillink.Controller;

import com.upc.proyecto.backendskillink.DTO.CartillaAsesorDTO;
import com.upc.proyecto.backendskillink.DTO.TemaAsesoriaDTO;
import com.upc.proyecto.backendskillink.Service.TemaAsesoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillink/temasesoria")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TemaAsesoriaController {

    @Autowired
    private TemaAsesoriaService temaAsesoriaService;

    @PostMapping("/registrar")
    public TemaAsesoriaDTO registrarTema(@RequestBody TemaAsesoriaDTO temaAsesoriaDTO) {
        return temaAsesoriaService.registrarTema(temaAsesoriaDTO);

    }

    @PutMapping("/actualizar/{idtema}")
    public TemaAsesoriaDTO actualizarTema(@PathVariable Long idtema, @RequestBody TemaAsesoriaDTO temaAsesoriaDTO) {
        temaAsesoriaDTO.setIdtema(idtema);
        return temaAsesoriaService.actualizarTema(temaAsesoriaDTO);
    }

    @DeleteMapping("/eliminar/{idtema}")
    public void eliminarTema(@PathVariable Long idtema) {
        temaAsesoriaService.eliminarTema(idtema);
    }



    @GetMapping("/listar")
    public List<TemaAsesoriaDTO> listarTemas() {
        return temaAsesoriaService.listarTemas();
    }

    @GetMapping("/verasesoria/{idverasesoria}")
    public List<TemaAsesoriaDTO> listarTemasPorVerAsesoria(@PathVariable Long idverasesoria) {
        return temaAsesoriaService.listarTemasPorVerAsesoria(idverasesoria);
    }





}
