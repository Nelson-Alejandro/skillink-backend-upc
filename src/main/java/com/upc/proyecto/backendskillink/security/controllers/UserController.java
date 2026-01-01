package com.upc.proyecto.backendskillink.security.controllers;

import com.upc.proyecto.backendskillink.security.entities.Role;
import com.upc.proyecto.backendskillink.security.entities.User;
import com.upc.proyecto.backendskillink.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "${ip.frontend}")
@CrossOrigin(origins = "${ip.frontend}", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder bcrypt;

    @PostMapping("/user")

    public void createUser(@RequestBody User user) {
        String bcryptPassword = bcrypt.encode(user.getPassword());
        user.setPassword(bcryptPassword);
        userService.save(user);
    }

    @PostMapping("/rol")

    public void createRol(@RequestBody Role rol) {
           userService.grabar(rol);
    }


    @PostMapping("/save/{user_id}/{rol_id}")

    public ResponseEntity<Void> saveUserRol(@PathVariable("user_id") Long user_id,
                                            @PathVariable("rol_id") Long rol_id) {

        userService.insertUserRole(user_id, rol_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
