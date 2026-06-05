package com.floriano.com.floriano.tcc_tracker_api.controllers;

import com.floriano.com.floriano.tcc_tracker_api.dto.LoginDTO;
import com.floriano.com.floriano.tcc_tracker_api.dto.LoginResponseDTO;
import com.floriano.com.floriano.tcc_tracker_api.dto.RegisterStudentDTO;
import com.floriano.com.floriano.tcc_tracker_api.infra.security.TokenService;
import com.floriano.com.floriano.tcc_tracker_api.model.user.User;
import com.floriano.com.floriano.tcc_tracker_api.services.StudentService.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    private final StudentService studentService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginDTO data
    ) {

        var usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        data.email(),
                        data.password()
                );

        var authentication =
                authenticationManager.authenticate(
                        usernamePassword
                );

        User user = (User) authentication.getPrincipal();

        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(
                new LoginResponseDTO(token)
        );
    }

    @PostMapping("/register-student")
    public ResponseEntity<LoginResponseDTO> registerStudent(
            @RequestBody RegisterStudentDTO data
    ) {

        User user = studentService.register(data);

        String token = tokenService.generateToken(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new LoginResponseDTO(token));
    }
}