package com.upc.proyecto.backendskillink.Interface;

import com.upc.proyecto.backendskillink.DTO.AdministradorDTO;
import com.upc.proyecto.backendskillink.DTO.AsesorDTO;
import com.upc.proyecto.backendskillink.DTO.AsesoriaDTO;
import com.upc.proyecto.backendskillink.DTO.ClienteDTO;

import java.time.LocalDate;
import java.util.List;

public interface IAdministradorService {
    public AdministradorDTO registrar (AdministradorDTO administradorDTO);
    public AdministradorDTO actualizar (AdministradorDTO administradorDTO);


}
