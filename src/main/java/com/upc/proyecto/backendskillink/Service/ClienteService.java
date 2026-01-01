package com.upc.proyecto.backendskillink.Service;

import com.upc.proyecto.backendskillink.DTO.ClienteDTO;
import com.upc.proyecto.backendskillink.Entities.Cliente;
import com.upc.proyecto.backendskillink.Interface.IClienteService;
import com.upc.proyecto.backendskillink.Repository.ClienteRepository;
import com.upc.proyecto.backendskillink.security.entities.User;
import com.upc.proyecto.backendskillink.security.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ClienteDTO registrar(ClienteDTO dto) {

      // Encriptar una sola vez
      String hashedPassword = passwordEncoder.encode(dto.getPassword());

      // 1. Crear cliente con contraseña encriptada
      Cliente cliente = new Cliente();
      cliente.setNombrecliente(dto.getNombrecliente());
      cliente.setCorreocliente(dto.getCorreocliente());
      cliente.setTelefonocliente(dto.getTelefonocliente());
      cliente.setDireccioncliente(dto.getDireccioncliente());
      cliente.setEstadocliente(dto.getEstadocliente());
      cliente.setPassword(hashedPassword); // ✔ se guarda encriptado

      Cliente savedCliente = clienteRepository.save(cliente);

      // 2. Crear User para login (misma contraseña encriptada)
      User user = new User();
      user.setUsername(dto.getNombrecliente()); // si usas correo para login, cambiar aquí
      user.setPassword(hashedPassword);        // misma clave encriptada

      userService.save(user);

      // 3. Vincular usuario con rol USUARIO
      Long userId = userService.findByUsername(dto.getNombrecliente()).getId();
      Long roleId = userService.findRoleIdByName("USUARIO");

      userService.insertUserRole(userId, roleId);

      return modelMapper.map(savedCliente, ClienteDTO.class);
    }

    @Override
    public ClienteDTO actualizar(ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente updatedCliente = clienteRepository.save(cliente);
        return modelMapper.map(updatedCliente, ClienteDTO.class);
    }

    @Override
    public ClienteDTO findByIdcliente(Long idcliente) {
        return clienteRepository.findById(idcliente)
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .orElse(null);
    }

    @Override
    public void eliminarcliente(Long idcliente) {
        clienteRepository.deleteById(idcliente);
    }

    @Override
    public List<ClienteDTO> listarcliente() {
        return clienteRepository.findAll()
                .stream()
                .map(c -> modelMapper.map(c, ClienteDTO.class))
                .toList();
    }


    @Override
    public List<ClienteDTO> listarporestadocliente(Boolean estadocliente) {
        return clienteRepository.findByEstadocliente(estadocliente)
                .stream()
                .map(c -> modelMapper.map(c, ClienteDTO.class))
                .toList();
    }

    public Cliente findByNombre(String nombre) {
        return clienteRepository.findByNombrecliente(nombre).orElse(null);
    }
}
