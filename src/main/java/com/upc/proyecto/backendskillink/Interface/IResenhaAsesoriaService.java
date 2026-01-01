package com.upc.proyecto.backendskillink.Interface;

import com.upc.proyecto.backendskillink.DTO.ResenhaAsesoriaDTO;

import java.time.LocalDate;
import java.util.List;

public interface IResenhaAsesoriaService {
    public ResenhaAsesoriaDTO findByIdresenha(Long idresenha);
    public ResenhaAsesoriaDTO registrar (ResenhaAsesoriaDTO resenhaAsesoriaDTO);
    public ResenhaAsesoriaDTO actualizar (ResenhaAsesoriaDTO resenhaAsesoriaDTO);
    public void eliminar (Long idresenha);
    public List<ResenhaAsesoriaDTO> listar();
    public List<ResenhaAsesoriaDTO> findByPuntajeresenha(Integer puntajeresenha);
    public List<ResenhaAsesoriaDTO> listarporfecharesenha(LocalDate fecharesenha);
}
