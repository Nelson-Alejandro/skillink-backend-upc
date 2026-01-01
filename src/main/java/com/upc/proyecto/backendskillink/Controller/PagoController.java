package com.upc.proyecto.backendskillink.Controller;

import com.upc.proyecto.backendskillink.DTO.PagoDTO;
import com.upc.proyecto.backendskillink.Service.PagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/skillink/pago")
public class PagoController {
    @Autowired
    private PagoService pagoService;


    @PostMapping("/registrar")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<PagoDTO> registrar(@Valid @RequestBody PagoDTO pagoDTO) {
        PagoDTO nuevoPago = pagoService.registrar(pagoDTO);
        return ResponseEntity.ok(nuevoPago);
    }


    @PutMapping("/actualizar")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<PagoDTO> actualizar(@Valid @RequestBody PagoDTO pagoDTO) {
        PagoDTO pagoActualizado = pagoService.actualizar(pagoDTO);
        return ResponseEntity.ok(pagoActualizado);
    }

    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<PagoDTO> buscarPorId(@PathVariable("id") Long idpago) {
        PagoDTO pago = pagoService.findByIdpago(idpago);
        return ResponseEntity.ok(pago);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long idpago) {
        pagoService.eliminar(idpago);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/listar")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<List<PagoDTO>> listar() {
        List<PagoDTO> lista = pagoService.listar();
        return ResponseEntity.ok(lista);
    }


    @GetMapping("/listar/fecha/{fecha}")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<List<PagoDTO>> listarPorFecha(@PathVariable("fecha") LocalDate fechapago) {
        List<PagoDTO> lista = pagoService.listarporfechapago(fechapago);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/listar/estado/{estado}")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<List<PagoDTO>> listarPorEstado(@PathVariable("estado") Boolean estadopago) {
        List<PagoDTO> lista = pagoService.listarporestadopago(estadopago);
        return ResponseEntity.ok(lista);
    }
}
