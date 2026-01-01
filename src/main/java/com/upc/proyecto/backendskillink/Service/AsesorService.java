package com.upc.proyecto.backendskillink.Service;

import com.upc.proyecto.backendskillink.DTO.AsesorDTO;
import com.upc.proyecto.backendskillink.Entities.Asesor;
import com.upc.proyecto.backendskillink.Interface.IAsesorService;
import com.upc.proyecto.backendskillink.Repository.AsesorRepository;
import com.upc.proyecto.backendskillink.security.entities.User;
import com.upc.proyecto.backendskillink.security.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsesorService implements IAsesorService {

    @Autowired
    private AsesorRepository asesorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;


    @Override
    public AsesorDTO findByIdasesor(Long idasesor) {
        return asesorRepository.findById(idasesor)
                .map(asesor -> modelMapper.map(asesor, AsesorDTO.class))
                .orElse(null);
    }


    @Override
    public AsesorDTO registrar(AsesorDTO dto) {

      // Encriptar una sola vez
      String hashedPassword = passwordEncoder.encode(dto.getPassword());

      // 1. Crear asesor con contraseña ya encriptada
      Asesor asesor = new Asesor();
      asesor.setNombreasesor(dto.getNombreasesor());
      asesor.setCorreoasesor(dto.getCorreoasesor());
      asesor.setTelefonoasesor(dto.getTelefonoasesor());
      asesor.setDireccionasesor(dto.getDireccionasesor());
      asesor.setEstadoasesor(dto.getEstadoasesor());
      asesor.setEspecialidadasesor(dto.getEspecialidadasesor());
      asesor.setPassword(hashedPassword); // ✔ contraseña encriptada

      Asesor savedAsesor = asesorRepository.save(asesor);

      // 2. Crear User para autenticación (misma clave hasheada)
      User user = new User();
      user.setUsername(dto.getNombreasesor()); // ⚠si prefieres login por correo, cambias aquí
      user.setPassword(hashedPassword);        //  YA encriptada

      userService.save(user);

      // 3. Insertar rol ASESOR
      Long userId = userService.findByUsername(dto.getNombreasesor()).getId();
      Long roleId = userService.findRoleIdByName("ASESOR");

      userService.insertUserRole(userId, roleId);

      return modelMapper.map(savedAsesor, AsesorDTO.class);
    }


    @Override
    public AsesorDTO actualizar(AsesorDTO asesorDTO) {
        Asesor asesor = modelMapper.map(asesorDTO, Asesor.class);
        Asesor updatedAsesor = asesorRepository.save(asesor);
        return modelMapper.map(updatedAsesor, AsesorDTO.class);
    }

    @Override
    public void eliminarasesor(Long idasesor) {
        asesorRepository.deleteById(idasesor);
    }

    @Override
    public List<AsesorDTO> listarasesor() {
        return asesorRepository.findAll()
                .stream()
                .map(asesor -> modelMapper.map(asesor, AsesorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AsesorDTO> listarporestadoasesor(Boolean estadoasesor) {
        return asesorRepository.findByEstadoasesor(estadoasesor)
                .stream()
                .map(asesor -> modelMapper.map(asesor, AsesorDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<AsesorDTO> listarporespecialidadasesor(String especialidadasesor) {
        return asesorRepository.findByEspecialidadasesor(especialidadasesor)
                .stream()
                .map(asesor -> modelMapper.map(asesor, AsesorDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public AsesorDTO findByEspecialidadasesor(String especialidadasesor) {
        return asesorRepository.findFirstByEspecialidadasesor(especialidadasesor)
                .map(asesor -> modelMapper.map(asesor, AsesorDTO.class))
                .orElse(null);
    }
    public Asesor findByNombre(String nombre) {
        return asesorRepository.findByNombreasesor(nombre).orElse(null);
    }
}
