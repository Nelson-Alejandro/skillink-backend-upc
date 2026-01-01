package com.upc.proyecto.backendskillink.security.services;


import com.upc.proyecto.backendskillink.security.entities.Role;
import com.upc.proyecto.backendskillink.security.entities.User;
import com.upc.proyecto.backendskillink.security.repositories.RoleRepository;
import com.upc.proyecto.backendskillink.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void grabar(Role role) {
        roleRepository.save(role);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public Long findRoleIdByName(String name) {
        return roleRepository.getRoleIdByName(name);
    }

    @Transactional
    public void insertUserRole(Long userId, Long roleId) {
        userRepository.insertUserRol(userId, roleId);
    }

}
