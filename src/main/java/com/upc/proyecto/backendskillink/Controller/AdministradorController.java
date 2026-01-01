package com.upc.proyecto.backendskillink.Controller;

import com.upc.proyecto.backendskillink.DTO.AdministradorDTO;
import com.upc.proyecto.backendskillink.DTO.AsesorDTO;
import com.upc.proyecto.backendskillink.DTO.AsesoriaDTO;
import com.upc.proyecto.backendskillink.DTO.ClienteDTO;
import com.upc.proyecto.backendskillink.Service.AdministradorService;
import com.upc.proyecto.backendskillink.Service.AsesorService;
import com.upc.proyecto.backendskillink.Service.AsesoriaService;
import com.upc.proyecto.backendskillink.Service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/skillink/administrador")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AdministradorController {

    private final AsesoriaService asesoriaService;
    private final AsesorService asesorService;
    private final ClienteService clienteService;
    private final AdministradorService administradorService;

    @PostMapping("/registrar")
    public ResponseEntity<AdministradorDTO> registrar(@Valid @RequestBody AdministradorDTO administradorDTO) {
        AdministradorDTO nuevoAdministrador = administradorService.registrar(administradorDTO);
        return ResponseEntity.ok(nuevoAdministrador);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<AdministradorDTO> actualizar(@Valid @RequestBody AdministradorDTO administradorDTO) {
        AdministradorDTO administradorActualizado = administradorService.actualizar(administradorDTO);
        return ResponseEntity.ok(administradorActualizado);
    }

    // ============================
    //        ASESORÍAS
    // ============================

    @GetMapping("/asesorias")
    public List<AsesoriaDTO> listarAsesorias() {
        return asesoriaService.listarasesoria();
    }

    @GetMapping("/asesorias/{id}")
    public AsesoriaDTO obtenerAsesoriaPorId(@PathVariable Long id) {
        return asesoriaService.findByIdasesoria(id);
    }

    @GetMapping("/asesorias/fecha/{fecha}")
    public List<AsesoriaDTO> listarAsesoriasPorFecha(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return asesoriaService.listarporfechasesoria(fecha);
    }

    @DeleteMapping("/asesorias/{id}")
    public void eliminarAsesoria(@PathVariable Long id) {
        asesoriaService.eliminarasesoria(id);
    }

    // ============================
    //           ASESORES
    // ============================

    @GetMapping("/asesores")
    public List<AsesorDTO> listarAsesores() {
        return asesorService.listarasesor();
    }

    @GetMapping("/asesores/{id}")
    public AsesorDTO obtenerAsesorPorId(@PathVariable Long id) {
        return asesorService.findByIdasesor(id);
    }

    @GetMapping("/asesores/estado/{estado}")
    public List<AsesorDTO> listarAsesoresPorEstado(@PathVariable Boolean estado) {
        return asesorService.listarporestadoasesor(estado);
    }

    @GetMapping("/asesores/especialidad/{especialidad}")
    public List<AsesorDTO> listarAsesoresPorEspecialidad(@PathVariable String especialidad) {
        return asesorService.listarporespecialidadasesor(especialidad);
    }

    @DeleteMapping("/asesores/{id}")
    public void eliminarAsesor(@PathVariable Long id) {
        asesorService.eliminarasesor(id);
    }


    @PutMapping("/asesores/{id}/estado")
    public ResponseEntity<AsesorDTO> actualizarEstado(
            @PathVariable Long id,
            @RequestBody Boolean nuevoEstado) {

        AsesorDTO actualizado = administradorService.actualizarEstadoAsesor(id, nuevoEstado);
        return ResponseEntity.ok(actualizado);
    }



    // ============================
    //           CLIENTES
    // ============================

    @GetMapping("/clientes")
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarcliente();
    }

    @GetMapping("/clientes/{id}")
    public ClienteDTO obtenerClientePorId(@PathVariable Long id) {
        return clienteService.findByIdcliente(id);
    }

    @GetMapping("/clientes/estado/{estado}")
    public List<ClienteDTO> listarClientesPorEstado(@PathVariable Boolean estado) {
        return clienteService.listarporestadocliente(estado);
    }

    @DeleteMapping("/clientes/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarcliente(id);
    }



    @PutMapping("/clientes/{id}/estado")
    public ResponseEntity<ClienteDTO> actualizarEstadoCliente(
            @PathVariable Long id,
            @RequestBody Boolean nuevoEstado) {

        ClienteDTO actualizado = administradorService.actualizarEstadoCliente(id, nuevoEstado);
        return ResponseEntity.ok(actualizado);
    }


}
