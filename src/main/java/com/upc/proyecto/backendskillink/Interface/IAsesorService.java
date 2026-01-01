package com.upc.proyecto.backendskillink.Interface;

import com.upc.proyecto.backendskillink.DTO.AsesorDTO;

import java.util.List;

public interface IAsesorService {
    public AsesorDTO registrar (AsesorDTO asesorDTO);
    public AsesorDTO actualizar (AsesorDTO asesorDTO);
    public void eliminarasesor(Long idasesor);
    public List<AsesorDTO> listarasesor();
    public List<AsesorDTO> listarporestadoasesor(Boolean estadoasesor);
    public List<AsesorDTO> listarporespecialidadasesor(String especialidadasesor);
    public AsesorDTO findByEspecialidadasesor(String especialidadasesor);
    public AsesorDTO findByIdasesor(Long idasesor);

}
