package com.upc.proyecto.backendskillink.Interface;

import com.upc.proyecto.backendskillink.DTO.CartillaAsesorDTO;

import java.util.List;

public interface ICartillaAsesorService {
    public CartillaAsesorDTO registrar_cartilla (CartillaAsesorDTO cartillaasesorDTO);
    public CartillaAsesorDTO actualizar_cartilla (CartillaAsesorDTO cartillaasesorDTO);
    public void eliminarcartillaasesor(Long idasesor);
    public List<CartillaAsesorDTO> listarcartillaasesores();
    public List<CartillaAsesorDTO> ordenarPorPrecioAsc();
    public List<CartillaAsesorDTO> ordenarPorAniosExperienciaDesc();
    public List<CartillaAsesorDTO> filtrarPorEstrellas(Integer estrellas);

}
