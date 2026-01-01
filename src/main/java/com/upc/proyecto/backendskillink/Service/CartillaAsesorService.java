package com.upc.proyecto.backendskillink.Service;

import com.upc.proyecto.backendskillink.DTO.CartillaAsesorDTO;
import com.upc.proyecto.backendskillink.Entities.CartillaAsesor;
import com.upc.proyecto.backendskillink.Interface.ICartillaAsesorService;
import com.upc.proyecto.backendskillink.Repository.CartillaAsesorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartillaAsesorService implements ICartillaAsesorService {

    @Autowired
    private CartillaAsesorRepository cartillaasesorrepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CartillaAsesorDTO registrar_cartilla(CartillaAsesorDTO cartillaasesorDTO) {
        CartillaAsesor cartillaAsesor = modelMapper.map(cartillaasesorDTO, CartillaAsesor.class);
        cartillaAsesor.setIdcartillaasesor(null);
        CartillaAsesor savedCartillaAsesor = cartillaasesorrepository.save(cartillaAsesor);
        return modelMapper.map(savedCartillaAsesor, CartillaAsesorDTO.class);
    }

    @Override
    public CartillaAsesorDTO actualizar_cartilla(CartillaAsesorDTO cartillaasesorDTO) {
        CartillaAsesor cartillaAsesor = modelMapper.map(cartillaasesorDTO, CartillaAsesor.class);
        cartillaAsesor.setIdcartillaasesor(null);
        CartillaAsesor savedCartillaAsesor = cartillaasesorrepository.save(cartillaAsesor);
        return modelMapper.map(savedCartillaAsesor, CartillaAsesorDTO.class);
    }

    @Override
    public void eliminarcartillaasesor(Long idasesor) {
        cartillaasesorrepository.deleteById(idasesor);
    }

    @Override
    public List<CartillaAsesorDTO> listarcartillaasesores() {
        return cartillaasesorrepository.findAll().stream()
                .map(cartillaasesor -> modelMapper.map(cartillaasesor, CartillaAsesorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CartillaAsesorDTO> ordenarPorPrecioAsc() {
        return cartillaasesorrepository.findAllByOrderByPreciocartillaasesorAsc().stream()
                .map(cartillaasesor -> modelMapper.map(cartillaasesor, CartillaAsesorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CartillaAsesorDTO> ordenarPorAniosExperienciaDesc() {
        return cartillaasesorrepository.findAllByOrderByAnhoexperienciacartillaasesorDesc().stream()
                .map(cartillaasesor -> modelMapper.map(cartillaasesor, CartillaAsesorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CartillaAsesorDTO> filtrarPorEstrellas(Integer estrellas) {
        return cartillaasesorrepository.findByEstrellascartillaasesor(estrellas).stream()
                .map(cartillaasesor -> modelMapper.map(cartillaasesor, CartillaAsesorDTO.class))
                .collect(Collectors.toList());
    }
}
