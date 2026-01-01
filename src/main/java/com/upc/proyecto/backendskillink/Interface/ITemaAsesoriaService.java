package com.upc.proyecto.backendskillink.Interface;

import com.upc.proyecto.backendskillink.DTO.TemaAsesoriaDTO;

import java.util.List;

public interface ITemaAsesoriaService {
    public TemaAsesoriaDTO registrarTema(TemaAsesoriaDTO temaAsesoriaDTO);
    public TemaAsesoriaDTO actualizarTema(TemaAsesoriaDTO temaAsesoriaDTO);
    public void eliminarTema(Long idtema);
    public List<TemaAsesoriaDTO> listarTemas();
    public List<TemaAsesoriaDTO> listarTemasPorVerAsesoria(Long idverasesoria);
}
