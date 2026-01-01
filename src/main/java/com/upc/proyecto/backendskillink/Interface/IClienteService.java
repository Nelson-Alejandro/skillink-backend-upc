package com.upc.proyecto.backendskillink.Interface;

import com.upc.proyecto.backendskillink.DTO.ClienteDTO;

import java.util.List;

public interface IClienteService {
    public ClienteDTO registrar (ClienteDTO clienteDTO);
    public ClienteDTO actualizar (ClienteDTO clienteDTO);
    public void eliminarcliente (Long idcliente);
    public List<ClienteDTO> listarcliente();
    public List<ClienteDTO> listarporestadocliente(Boolean estadocliente);
    public ClienteDTO findByIdcliente(Long idcliente);


}
