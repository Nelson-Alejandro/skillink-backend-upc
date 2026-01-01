# Guía de Contribución – Skillink Backend

Gracias por tu interés en contribuir al proyecto **Skillink Backend**, desarrollado como proyecto académico del sexto ciclo de la carrera de Ingeniería de Sistemas de Información en la Universidad Peruana de Ciencias Aplicadas (UPC).

Este documento define las reglas y buenas prácticas para mantener un código limpio, ordenado y consistente.

---

## Estructura del Proyecto

El código fuente se encuentra dentro de la carpeta `origen/` y sigue una arquitectura basada en capas:

- **Controller**: Controladores REST
- **Service**: Lógica de negocio
- **Repository**: Acceso a datos (JPA)
- **Entities**: Entidades del dominio
- **DTO**: Objetos de transferencia de datos
- **Config / security**: Configuración y seguridad

### Buenas Prácticas

- Usar anotaciones de Spring correctamente (`@Service`, `@Repository`, `@RestController`)
- Separar lógica de negocio del controlador
- No exponer entidades directamente (usar DTO)
- Evitar código duplicado
- Agregar comentarios o JavaDoc cuando sea necesario