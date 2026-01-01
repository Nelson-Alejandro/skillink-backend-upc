package com.upc.proyecto.backendskillink.security.config;

import com.upc.proyecto.backendskillink.security.filters.JwtRequestFilter;
import com.upc.proyecto.backendskillink.security.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(CustomUserDetailsService userDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

  // AuthenticationManager + BCrypt + UserDetailsService
  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder authManagerBuilder =
      http.getSharedObject(AuthenticationManagerBuilder.class);

    authManagerBuilder
      .userDetailsService(userDetailsService)
      .passwordEncoder(passwordEncoder());  // *** IMPORTANTE ***

    return authManagerBuilder.build();
  }


  @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();// texto plano
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> {})
                .authorizeHttpRequests(auth -> auth
                        // LOGIN
                        .requestMatchers("/api/authenticate").permitAll()

                        // Registro de usuario público
                        .requestMatchers("/api/skillink/usuario/registrar").permitAll()
                        .requestMatchers("/api/skillink/asesor/registrar").permitAll()
                        .requestMatchers("/api/skillink/administrador/registrar").permitAll()
                        .requestMatchers("/api/skillink/asesoria/listar").permitAll()
                        // Este SÍ debe ser público para mostrar carta de asesores
                        .requestMatchers("/api/skillink/cartillaasesor/listarcartilla").permitAll()
                        // ⚠ Quita esto: ya no debe ser público, lo controlarás por @PreAuthorize
                        // .requestMatchers("/api/skillink/administrador/").permitAll()
                        // Si estos realmente deben ser públicos, déjalos:
                        .requestMatchers("/api/skillink/asesoria/listar").permitAll()
                        .requestMatchers("/api/skillink/verasesoria/**").permitAll()
                        .requestMatchers("/api/skillink/temasesoria/**").permitAll()

                        // Para mostrar imágenes
                        .requestMatchers("/Imagenes/**").permitAll()

                        // Todo lo demás necesita JWT
                        .anyRequest().authenticated()
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .userDetailsService(userDetailsService);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

  // Permitir Angular
  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("http://localhost:4200");
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}
