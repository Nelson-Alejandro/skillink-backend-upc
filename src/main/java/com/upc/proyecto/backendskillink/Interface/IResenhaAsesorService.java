package com.upc.proyecto.backendskillink.Interface;

import com.upc.proyecto.backendskillink.DTO.ResenhaAsesorDTO;

import java.time.LocalDate;
import java.util.List;

public interface IResenhaAsesorService {
    public ResenhaAsesorDTO findByIdresenha(Long idresenha);
    public ResenhaAsesorDTO registrar (ResenhaAsesorDTO resenhaAsesorDTO);
    public ResenhaAsesorDTO actualizar (ResenhaAsesorDTO resenhaAsesorDTO);
    public void eliminar (Long idresenha);
    public List<ResenhaAsesorDTO> listar();
    public List<ResenhaAsesorDTO> findByPuntajeresenha(Integer puntajeresenha);
    public List<ResenhaAsesorDTO> listarporfecharesenha(LocalDate fecharesenha);
}
