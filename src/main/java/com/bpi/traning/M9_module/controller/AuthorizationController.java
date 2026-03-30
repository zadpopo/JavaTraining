package com.bpi.traning.M9_module.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorizationController {

    @GetMapping("/home")
    @PreAuthorize("hasAnyRole('USER', 'MANAGER')")
    public String home() {
        return "Welcome to the portal";
    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('USER')")
    public String dashboard() {
        return "User dashboard";
    }

    @GetMapping("/reports")
    @PreAuthorize("hasRole('MANAGER')")
    public String reports() {
        return "Manager reports";
    }

    @GetMapping("/profile/{username}")
    @PreAuthorize("#username == authentication.name")
    public String getProfileByUsername(@PathVariable String username) {
        return "Profile of " + username;
    }
}