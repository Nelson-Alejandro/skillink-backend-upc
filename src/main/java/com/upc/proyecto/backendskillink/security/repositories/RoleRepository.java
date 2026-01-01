package com.upc.proyecto.backendskillink.security.repositories;
import com.upc.proyecto.backendskillink.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "SELECT id FROM roles WHERE name = :name", nativeQuery = true)
    Long getRoleIdByName(String name);
}
