package com.bpi.traning.M9_module.controller;

import com.bpi.traning.M9_module.dto.UserDto;
import com.bpi.traning.M9_module.model.Role;
import com.bpi.traning.M9_module.model.User;
import com.bpi.traning.M9_module.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto request) {

        if (userRepository.findByUsername(request.username).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error: Username already exists.");
        }

        User user = new User();
        user.setUsername(request.username);
        user.setPassword(passwordEncoder.encode(request.password));
        user.setEnabled(request.enabled);

        List<Role> roles = new ArrayList<>();
        for (String roleName : request.roles) {
            Role role = new Role();
            role.setRole(roleName.toUpperCase());
            role.setUser(user);
            roles.add(role);
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok("User created successfully!");
    }
    

	@GetMapping("/all")
	public List<UserDto> getAllUsers() {
	    return userRepository.findAll().stream().map(user -> {
	
	        UserDto dto = new UserDto();
	        dto.username = user.getUsername();
	        dto.password = user.getPassword();
	        dto.enabled = user.isEnabled();
	        dto.roles = user.getRoles().stream()
	                .map(Role::getRole)
	                .toList();
	        return dto;
	    }).toList();
	}

}