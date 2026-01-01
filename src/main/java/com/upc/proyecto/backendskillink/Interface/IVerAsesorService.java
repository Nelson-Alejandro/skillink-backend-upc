package com.upc.proyecto.backendskillink.Interface;

import com.upc.proyecto.backendskillink.DTO.VerAsesorDTO;

import java.util.List;

public interface IVerAsesorService {
    public List<VerAsesorDTO> listarVerAsesor();
    public VerAsesorDTO obtenerVerAsesorPorId(Long idverasesor);
}
