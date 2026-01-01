package com.upc.proyecto.backendskillink.Service;

import com.upc.proyecto.backendskillink.DTO.TemaAsesoriaDTO;
import com.upc.proyecto.backendskillink.Entities.TemaAsesoria;
import com.upc.proyecto.backendskillink.Interface.ITemaAsesoriaService;
import com.upc.proyecto.backendskillink.Repository.TemaAsesoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaAsesoriaService implements ITemaAsesoriaService {

    @Autowired
    private TemaAsesoriaRepository temaAsesoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TemaAsesoriaDTO registrarTema(TemaAsesoriaDTO temaAsesoriaDTO) {
        TemaAsesoria temasasesoria = modelMapper.map(temaAsesoriaDTO, TemaAsesoria.class);
        temasasesoria.setIdtema(null);
        TemaAsesoria savedtemasasesoria = temaAsesoriaRepository.save(temasasesoria);
        return modelMapper.map(savedtemasasesoria, TemaAsesoriaDTO.class);
    }

    @Override
    public TemaAsesoriaDTO actualizarTema(TemaAsesoriaDTO temaAsesoriaDTO) {
        TemaAsesoria temasasesoria = modelMapper.map(temaAsesoriaDTO, TemaAsesoria.class);
        temasasesoria.setIdtema(null);
        TemaAsesoria savedtemasasesoria = temaAsesoriaRepository.save(temasasesoria);
        return modelMapper.map(savedtemasasesoria, TemaAsesoriaDTO.class);
    }

    @Override
    public void eliminarTema(Long idtema) {
        temaAsesoriaRepository.deleteById(idtema);

    }

    @Override
    public List<TemaAsesoriaDTO> listarTemas() {
        return temaAsesoriaRepository.findAll().stream()
                .map(temaslistar -> modelMapper.map(temaslistar, TemaAsesoriaDTO.class))
                .toList();

    }

    @Override
    public List<TemaAsesoriaDTO> listarTemasPorVerAsesoria(Long idverasesoria) {
        List<TemaAsesoria> temas = temaAsesoriaRepository.findByVerAsesoria_Idverasesoria(idverasesoria);
        return temas.stream()
                .map(t -> modelMapper.map(t, TemaAsesoriaDTO.class))
                .toList();
    }
}
