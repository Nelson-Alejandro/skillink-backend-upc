package com.upc.proyecto.backendskillink.Interface;

import com.upc.proyecto.backendskillink.DTO.AsesoriaDTO;

import java.time.LocalDate;
import java.util.List;

public interface IAsesoriaService {
    public AsesoriaDTO registrar (AsesoriaDTO asesoriaDTO);
    public AsesoriaDTO actualizar (AsesoriaDTO asesoriaDTO);
    public void eliminarasesoria (Long idasesoria);
    public List<AsesoriaDTO> listarasesoria();
    public List<AsesoriaDTO> listarporfechasesoria(LocalDate fechasesoria);
    public AsesoriaDTO findByIdasesoria(Long idasesoria);

}
