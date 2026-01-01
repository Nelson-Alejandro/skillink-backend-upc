# Skillink Backend - UPC

Sistema de gestión de asesorías académicas desarrollado como proyecto del sexto ciclo de Ingeniería de Sistemas de Información la Universidad Peruana de Ciencias Aplicadas (UPC).

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-12+-blue)
![License](https://img.shields.io/badge/License-Academic-yellow)
![UPC](https://img.shields.io/badge/UPC-Ciclo%206-red)

## Descripción

Skillink es una plataforma que conecta estudiantes con asesores especializados en diferentes áreas académicas. El backend proporciona una API RESTful desarrollada en Spring Boot que gestiona usuarios, asesorías, pagos y reseñas.

## Equipo de Desarrollo

- **Javier Chumpitazi** 
- **Lehonel Cachay** 
- **Jose Matos** 
- **Jhair Martel** 
- **Nelson Alejandro** 

*Proyecto desarrollado en el ciclo 2025-2*

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security (JWT)**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Hibernate**

## Características Principales

- Autenticación y autorización con JWT
- Gestión de usuarios (Administradores, Asesores, Clientes)
- Sistema de asesorías y reservas
- Procesamiento de pagos
- Sistema de reseñas y calificaciones
- API RESTful documentada

## Instalación

### Prerrequisitos

- Java 17 o superior
- PostgreSQL 12 o superior
- Maven 3.8 o superior

### Pasos

1. **Clonar**
```bash
git clone https://github.com/Nelson-Alejandro/skillink-backend-upc.git
cd skillink-backend-upc
```

2. **Base de datos**
```sql
CREATE DATABASE skillink;
```

3. **Configurar** `application.properties`
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/skillink
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
jwt.secret=tu_clave_secreta
```

4. **Ejecutar**
```bash
mvn spring-boot:run
```
