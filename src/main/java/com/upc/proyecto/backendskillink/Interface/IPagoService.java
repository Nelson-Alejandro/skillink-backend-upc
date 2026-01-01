package com.upc.proyecto.backendskillink.Interface;

import com.upc.proyecto.backendskillink.DTO.PagoDTO;

import java.time.LocalDate;
import java.util.List;

public interface IPagoService {
    public PagoDTO findByIdpago(Long idpago);
    public PagoDTO registrar (PagoDTO pagoDTO);
    public PagoDTO actualizar (PagoDTO pagoDTO);
    public void eliminar (Long idpago);
    public List<PagoDTO> listar();
    public List<PagoDTO> listarporfechapago(LocalDate fechapago);
    public List<PagoDTO> listarporestadopago(Boolean estadopago);
}
