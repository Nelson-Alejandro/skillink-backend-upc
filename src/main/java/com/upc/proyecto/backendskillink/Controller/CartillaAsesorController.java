package com.upc.proyecto.backendskillink.Controller;

import com.upc.proyecto.backendskillink.DTO.CartillaAsesorDTO;
import com.upc.proyecto.backendskillink.Service.CartillaAsesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillink/cartillaasesor")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CartillaAsesorController {

    @Autowired
    private CartillaAsesorService cartillaAsesorService;

    @PostMapping("/registrarcartilla")
    @PreAuthorize("hasAuthority('ASESOR')")

    public CartillaAsesorDTO crearCartilla(@RequestBody CartillaAsesorDTO dto) {
        return cartillaAsesorService.registrar_cartilla(dto);
    }

    @PutMapping("/actualizarcartilla")
    @PreAuthorize("hasAuthority('ASESOR')")

    public CartillaAsesorDTO actualizarCartilla(@RequestBody CartillaAsesorDTO dto) {
        return cartillaAsesorService.actualizar_cartilla(dto);
    }

    @DeleteMapping("/eliminarcartilla/{id}")
    public void eliminarCartilla(@PathVariable Long id) {
        cartillaAsesorService.eliminarcartillaasesor(id);
    }

    @GetMapping("/listarcartilla")
    public List<CartillaAsesorDTO> listarCartillas() {
        return cartillaAsesorService.listarcartillaasesores();
    }

    @GetMapping("/ordenar/precio")
    public List<CartillaAsesorDTO> ordenarPorPrecioAsc() {
        return cartillaAsesorService.ordenarPorPrecioAsc();
    }

    @GetMapping("/ordenar/experiencia")
    public List<CartillaAsesorDTO> ordenarPorAniosExperienciaDesc() {
        return cartillaAsesorService.ordenarPorAniosExperienciaDesc();
    }

    @GetMapping("/filtrar/estrellas")
    public List<CartillaAsesorDTO> filtrarPorEstrellas(@RequestParam Integer estrellas) {
        return cartillaAsesorService.filtrarPorEstrellas(estrellas);
    }

}
