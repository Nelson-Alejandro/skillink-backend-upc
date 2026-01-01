package com.upc.proyecto.backendskillink.security.repositories;


import com.upc.proyecto.backendskillink.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users u WHERE u.username = :username", nativeQuery = true)
    Optional<User> findByUsername(String username);

    @Modifying
    @Query(value = "INSERT INTO user_roles(user_id, role_id) VALUES (:userId, :roleId)", nativeQuery = true)
    void insertUserRol(@Param("userId") Long userId, @Param("roleId") Long roleId);
}
