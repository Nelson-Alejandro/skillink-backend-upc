package com.upc.proyecto.backendskillink.Service;

import com.upc.proyecto.backendskillink.DTO.ResenhaAsesorDTO;
import com.upc.proyecto.backendskillink.Entities.ResenhaAsesor;
import com.upc.proyecto.backendskillink.Interface.IResenhaAsesorService;
import com.upc.proyecto.backendskillink.Repository.ResenhaAsesorRepository;
import com.upc.proyecto.backendskillink.Repository.ResenhaAsesoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResenhaAsesorService implements IResenhaAsesorService {
    @Autowired
    private ResenhaAsesorRepository resenhaAsesorRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ResenhaAsesorDTO findByIdresenha(Long idresenha) {
        return resenhaAsesorRepository.findById(idresenha)
                .map(resenhaasesor -> modelMapper.map(resenhaasesor, ResenhaAsesorDTO.class))
                .orElse(null);
    }

    @Override
    public ResenhaAsesorDTO registrar(ResenhaAsesorDTO resenhaAsesorDTO) {
        ResenhaAsesor resenhaAsesor = modelMapper.map(resenhaAsesorDTO, ResenhaAsesor.class);
        resenhaAsesor.setIdresenha(null);
        ResenhaAsesor savedResenha = resenhaAsesorRepository.save(resenhaAsesor);
        return modelMapper.map(savedResenha, ResenhaAsesorDTO.class);
    }

    @Override
    public ResenhaAsesorDTO actualizar(ResenhaAsesorDTO resenhaAsesorDTO) {
        ResenhaAsesor resenhaAsesor = modelMapper.map(resenhaAsesorDTO, ResenhaAsesor.class);
        ResenhaAsesor UpdateResenhaAsesor = resenhaAsesorRepository.save(resenhaAsesor);
        return modelMapper.map(UpdateResenhaAsesor, ResenhaAsesorDTO.class);
    }

    @Override
    public void eliminar(Long idresenha) {
        resenhaAsesorRepository.deleteById(idresenha);
    }

    @Override
    public List<ResenhaAsesorDTO> listar() {
        return resenhaAsesorRepository.findAll().stream()
                .map(resenhaasesor -> modelMapper.map(resenhaasesor, ResenhaAsesorDTO.class))
                .toList();
    }

    @Override
    public List<ResenhaAsesorDTO> findByPuntajeresenha(Integer puntajeresenha) {
        return resenhaAsesorRepository.findByPuntajeresenha(puntajeresenha)
                .stream()
                .map(resenhaasesor -> modelMapper.map(resenhaasesor, ResenhaAsesorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ResenhaAsesorDTO> listarporfecharesenha(LocalDate fecharesenha) {
        return resenhaAsesorRepository.findByFecharesenha(fecharesenha)
                .stream()
                .map(resenhaasesor -> modelMapper.map(resenhaasesor, ResenhaAsesorDTO.class))
                .collect(Collectors.toList());
    }
}
