package com.upc.proyecto.backendskillink.Controller;

import com.upc.proyecto.backendskillink.DTO.ClienteDTO;
import com.upc.proyecto.backendskillink.Service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillink/usuario")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;


    @PostMapping("/registrar")
    public ResponseEntity<ClienteDTO> registrar(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO nuevoCliente = clienteService.registrar(clienteDTO);
        return ResponseEntity.ok(nuevoCliente);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ClienteDTO> actualizar(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteActualizado = clienteService.actualizar(clienteDTO);
        return ResponseEntity.ok(clienteActualizado);
    }

    @GetMapping("/listar")
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarcliente();
    }

}