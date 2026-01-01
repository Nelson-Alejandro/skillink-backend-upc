package com.upc.proyecto.backendskillink.Service;

import com.upc.proyecto.backendskillink.DTO.VerAsesoriaDTO;
import com.upc.proyecto.backendskillink.Entities.Asesoria;
import com.upc.proyecto.backendskillink.Entities.VerAsesoria;
import com.upc.proyecto.backendskillink.Interface.IVerAsesoriaService;
import com.upc.proyecto.backendskillink.Repository.AsesoriaRepository;
import com.upc.proyecto.backendskillink.Repository.VerAsesoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VerAsesoriaService implements IVerAsesoriaService {
    @Autowired
    private VerAsesoriaRepository verAsesoriaRepository;

    @Autowired
    private AsesoriaRepository asesoriaRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<VerAsesoriaDTO> listarVerAsesorias() {
        return verAsesoriaRepository.findAll().stream()
                .map(verasesoria -> modelMapper.map(verasesoria, VerAsesoriaDTO.class))
                .toList();
    }

    @Override
    public VerAsesoriaDTO obtenerVerAsesoriaPorId(Long idverasesoria) {
        return verAsesoriaRepository.findById(idverasesoria)
                .map(verasesoriaid -> modelMapper.map(verasesoriaid, VerAsesoriaDTO.class))
                .orElse(null);
    }

    public VerAsesoriaDTO obtenerPorIdAsesoria(Long idasesoria) {
        System.out.println(" Buscando asesoría con ID: " + idasesoria);

        Asesoria asesoria = asesoriaRepository.findById(idasesoria)
                .orElseThrow(() -> new RuntimeException("Asesoría no encontrada con ID: " + idasesoria));

        System.out.println(" Asesoría encontrada: " + asesoria.getNombreasesoria());

        // Buscar VerAsesoria asociada a esta Asesoría
        List<VerAsesoria> verAsesorias = verAsesoriaRepository.findByAsesoria_Idasesoria(idasesoria);

        VerAsesoriaDTO dto = new VerAsesoriaDTO();
        dto.setAsesoria(asesoria);

        if (verAsesorias != null && !verAsesorias.isEmpty()) {
            // Tomar la primera VerAsesoria encontrada
            VerAsesoria verAsesoria = verAsesorias.get(0);
            dto.setIdverasesoria(verAsesoria.getIdverasesoria());
            dto.setDescripcionVerAsesoria(verAsesoria.getDescricionverasesoria());
            dto.setTemasAsesoria(verAsesoria.getTemasAsesoria() != null ? verAsesoria.getTemasAsesoria() : new ArrayList<>());
            dto.setResenhas(verAsesoria.getResenhas() != null ? verAsesoria.getResenhas() : new ArrayList<>());
            dto.setPago(verAsesoria.getPago());
            System.out.println(" VerAsesoria encontrada con " + dto.getTemasAsesoria().size() + " temas y " + dto.getResenhas().size() + " reseñas");
        } else {
            // Si no existe VerAsesoria, crear con listas vacías
            dto.setTemasAsesoria(new ArrayList<>());
            dto.setResenhas(new ArrayList<>());
            dto.setDescripcionVerAsesoria(asesoria.getDescripcionasesoria());
            System.out.println(" No se encontró VerAsesoria para esta Asesoría");
        }

        return dto;
    }
}