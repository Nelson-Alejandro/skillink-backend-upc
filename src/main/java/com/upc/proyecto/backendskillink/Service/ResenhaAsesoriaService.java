package com.upc.proyecto.backendskillink.Service;

import com.upc.proyecto.backendskillink.DTO.ResenhaAsesoriaDTO;
import com.upc.proyecto.backendskillink.Entities.ResenhaAsesoria;
import com.upc.proyecto.backendskillink.Interface.IResenhaAsesoriaService;
import com.upc.proyecto.backendskillink.Repository.ResenhaAsesoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResenhaAsesoriaService implements IResenhaAsesoriaService {
    @Autowired
    private ResenhaAsesoriaRepository resenhaAsesoriaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResenhaAsesoriaDTO findByIdresenha(Long idresenha) {
        return resenhaAsesoriaRepository.findById(idresenha)
                .map(resenhaasesoria -> modelMapper.map(resenhaasesoria, ResenhaAsesoriaDTO.class))
                .orElse(null);
    }

    @Override
    public ResenhaAsesoriaDTO registrar(ResenhaAsesoriaDTO resenhaAsesoriaDTO) {
        ResenhaAsesoria resenhaasesoria = modelMapper.map(resenhaAsesoriaDTO, ResenhaAsesoria.class);
        resenhaasesoria.setIdresenha(null);
        ResenhaAsesoria savedResenhaasesoria = resenhaAsesoriaRepository.save(resenhaasesoria);
        return modelMapper.map(savedResenhaasesoria, ResenhaAsesoriaDTO.class);
    }

    @Override
    public ResenhaAsesoriaDTO actualizar(ResenhaAsesoriaDTO resenhaAsesoriaDTO) {
        ResenhaAsesoria resenhaasesoria = modelMapper.map(resenhaAsesoriaDTO, ResenhaAsesoria.class);
        ResenhaAsesoria UpdateResenhaasesoria = resenhaAsesoriaRepository.save(resenhaasesoria);
        return modelMapper.map(UpdateResenhaasesoria, ResenhaAsesoriaDTO.class);
    }

    @Override
    public void eliminar(Long idresenha) {
        resenhaAsesoriaRepository.deleteById(idresenha);
    }

    @Override
    public List<ResenhaAsesoriaDTO> listar() {
        return resenhaAsesoriaRepository.findAll().stream()
                .map(resenhaasesoria -> modelMapper.map(resenhaasesoria, ResenhaAsesoriaDTO.class))
                .toList();
    }

    @Override
    public List<ResenhaAsesoriaDTO> findByPuntajeresenha(Integer puntajeresenha) {
        return resenhaAsesoriaRepository.findByPuntajeresenha(puntajeresenha)
                .stream()
                .map(resenhaasesoria -> modelMapper.map(resenhaasesoria, ResenhaAsesoriaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ResenhaAsesoriaDTO> listarporfecharesenha(LocalDate fecharesenha) {
        return resenhaAsesoriaRepository.findByFecharesenha(fecharesenha)
                .stream()
                .map(resenhaasesoria -> modelMapper.map(resenhaasesoria, ResenhaAsesoriaDTO.class))
                .collect(Collectors.toList());
    }
}
