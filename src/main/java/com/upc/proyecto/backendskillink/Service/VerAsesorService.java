package com.upc.proyecto.backendskillink.Service;

import com.upc.proyecto.backendskillink.DTO.VerAsesorDTO;
import com.upc.proyecto.backendskillink.Interface.IVerAsesorService;
import com.upc.proyecto.backendskillink.Repository.VerAsesorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerAsesorService implements IVerAsesorService {

  @Autowired
  private VerAsesorRepository verasesorrepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public List<VerAsesorDTO> listarVerAsesor() {
    return verasesorrepository.findAll().stream()
      .map(verasesor -> modelMapper.map(verasesor, VerAsesorDTO.class))
      .toList();
  }

  @Override
  public VerAsesorDTO obtenerVerAsesorPorId(Long idverasesor) {
    return verasesorrepository.findById(idverasesor)
      .map(verasesorid -> modelMapper.map(verasesorid, VerAsesorDTO.class))
      .orElse(null);
  }
}
