package com.upc.proyecto.backendskillink.security.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "${ip.frontend}")
@CrossOrigin(origins = "${ip.frontend}", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/admin")

    public String adminEndpoint() {
        return "This is the admin endpoint, accessible only to users with ADMIN role.";
    }

    @GetMapping("/user")

    public String userEndpoint() {
        return "This is the user endpoint, accessible to users with USER or ADMIN role.";
    }
}
