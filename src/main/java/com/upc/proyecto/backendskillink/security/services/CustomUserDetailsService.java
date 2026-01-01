package com.upc.proyecto.backendskillink.security.services;
import com.upc.proyecto.backendskillink.security.entities.User;
import com.upc.proyecto.backendskillink.security.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
/**
 * Busca al usuario en la BD por su username.
 * Si no existe → lanza excepción.
 * Convierte sus roles en GrantedAuthority.
 * Devuelve un UserDetails que Spring Security usará para:
 * - Verificar la contraseña al hacer login.
 * - Saber qué roles/authorities tiene para autorización (@PreAuthorize, .hasRole(), etc.).
 * ------------------
 * Su propósito principal es cargar los detalles de un usuario a partir de un identificador,
 * que generalmente es el nombre de usuario (username).
 * Es usado por JwtRequestFilter
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    Set<GrantedAuthority> authorities = user.getRoles().stream()
      .map(role -> new SimpleGrantedAuthority(role.getName()))
      .collect(Collectors.toSet());

    return org.springframework.security.core.userdetails.User
      .withUsername(user.getUsername())
      .password(user.getPassword())
      .authorities(authorities)
      .build();
  }
}
