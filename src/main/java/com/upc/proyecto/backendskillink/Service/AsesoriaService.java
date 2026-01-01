package com.upc.proyecto.backendskillink.Service;

import com.upc.proyecto.backendskillink.DTO.AsesoriaDTO;
import com.upc.proyecto.backendskillink.Entities.Asesoria;
import com.upc.proyecto.backendskillink.Interface.IAsesoriaService;
import com.upc.proyecto.backendskillink.Repository.AsesoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsesoriaService implements IAsesoriaService {
    @Autowired
    private AsesoriaRepository asesoriaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AsesoriaDTO registrar(AsesoriaDTO asesoriaDTO) {
        Asesoria asesoria = modelMapper.map(asesoriaDTO, Asesoria.class);
        asesoria.setIdasesoria(null);
        Asesoria savedAsesoria = asesoriaRepository.save(asesoria);
        return modelMapper.map(savedAsesoria, AsesoriaDTO.class);
    }

    @Override
    public AsesoriaDTO actualizar(AsesoriaDTO asesoriaDTO) {
        Asesoria asesoria = modelMapper.map(asesoriaDTO, Asesoria.class);
        asesoria.setIdasesoria(null);
        Asesoria savedAsesoria = asesoriaRepository.save(asesoria);
        return modelMapper.map(savedAsesoria, AsesoriaDTO.class);
    }

    @Override
    public AsesoriaDTO findByIdasesoria(Long idasesoria) {
        return asesoriaRepository.findById(idasesoria)
                .map(asesoria -> modelMapper.map(asesoria, AsesoriaDTO.class))
                .orElse(null);
    }

    @Override
    public void eliminarasesoria(Long idasesoria) {
        asesoriaRepository.deleteById(idasesoria);
    }

    @Override
    public List<AsesoriaDTO> listarasesoria() {
        return asesoriaRepository.findAll().stream()
                .map(asesoria -> modelMapper.map(asesoria, AsesoriaDTO.class))
                .toList();
    }


    @Override
    public List<AsesoriaDTO> listarporfechasesoria(LocalDate fechasesoria) {
        List<Asesoria> asesorias = asesoriaRepository.findByFechasesoria(fechasesoria);
        return asesorias.stream()
                .map(asesoria -> modelMapper.map(asesoria, AsesoriaDTO.class))
                .collect(Collectors.toList());
    }
}
