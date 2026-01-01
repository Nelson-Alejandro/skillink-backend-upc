package com.upc.proyecto.backendskillink.Controller;

import com.upc.proyecto.backendskillink.DTO.VerAsesorDTO;
import com.upc.proyecto.backendskillink.Service.VerAsesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillink/verasesor")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VerAsesorController {

  @Autowired
  private VerAsesorService verasesorservice;

  @GetMapping("/listarverasesor")
  public List<VerAsesorDTO> listarVerAsesor() {
    return verasesorservice.listarVerAsesor();
  }

  @GetMapping("/listarverasesor/{idverasesor}")
  public VerAsesorDTO obtenerVerAsesorPorId(@PathVariable Long idverasesor) {
    return verasesorservice.obtenerVerAsesorPorId(idverasesor);
  }

}
