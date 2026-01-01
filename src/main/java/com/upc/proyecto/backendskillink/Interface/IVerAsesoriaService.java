package com.upc.proyecto.backendskillink.Interface;

import com.upc.proyecto.backendskillink.DTO.VerAsesoriaDTO;

import java.util.List;

public interface IVerAsesoriaService {
    public List<VerAsesoriaDTO> listarVerAsesorias();
    public VerAsesoriaDTO obtenerVerAsesoriaPorId(Long idverasesoria);
}
