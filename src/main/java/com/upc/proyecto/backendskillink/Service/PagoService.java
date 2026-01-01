package com.upc.proyecto.backendskillink.Service;

import com.upc.proyecto.backendskillink.DTO.PagoDTO;
import com.upc.proyecto.backendskillink.Entities.Pago;
import com.upc.proyecto.backendskillink.Interface.IPagoService;
import com.upc.proyecto.backendskillink.Repository.PagoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoService implements IPagoService {
    @Autowired
    private PagoRepository pagoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PagoDTO findByIdpago(Long idpago) {
        return pagoRepository.findById(idpago)
                .map(pago -> modelMapper.map(pago, PagoDTO.class))
                .orElse(null);
    }

    @Override
    public PagoDTO registrar(PagoDTO pagoDTO) {
        Pago pago = modelMapper.map(pagoDTO, Pago.class);
        pago.setIdpago(null);
        Pago savedPago = pagoRepository.save(pago);
        return modelMapper.map(savedPago, PagoDTO.class);
    }

    @Override
    public PagoDTO actualizar(PagoDTO pagoDTO) {
        Pago pago = modelMapper.map(pagoDTO, Pago.class);
        Pago UpdatePago = pagoRepository.save(pago);
        return modelMapper.map(UpdatePago, PagoDTO.class);
    }

    @Override
    public void eliminar(Long idpago) {
        pagoRepository.deleteById(idpago);
    }

    @Override
    public List<PagoDTO> listar() {
        return pagoRepository.findAll().stream()
                .map(pago -> modelMapper.map(pago, PagoDTO.class))
                .toList();
    }

    @Override
    public List<PagoDTO> listarporfechapago(LocalDate fechapago) {
        return pagoRepository.findByFechapago(fechapago)
                .stream()
                .map(pago -> modelMapper.map(pago, PagoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PagoDTO> listarporestadopago(Boolean estadopago) {
        return pagoRepository.findByEstadopago(estadopago)
                .stream()
                .map(pago -> modelMapper.map(pago, PagoDTO.class))
                .collect(Collectors.toList());
    }
}
