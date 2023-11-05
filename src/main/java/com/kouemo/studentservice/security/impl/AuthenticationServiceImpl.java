package com.kouemo.studentservice.security.impl;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.kouemo.studentservice.feature.entities.Role;
import com.kouemo.studentservice.feature.entities.User;
import com.kouemo.studentservice.feature.repositories.UserRepository;
import com.kouemo.studentservice.security.AuthenticationService;
import com.kouemo.studentservice.security.JwtService;
import com.kouemo.studentservice.security.request.SignInRequest;
import com.kouemo.studentservice.security.request.SignUpRequest;
import com.kouemo.studentservice.security.response.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder()
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .emailAddress(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of(Role.builder()
                                .key("SUPER_USER")
                                .description("ACCESS TO ALL RESSOURCES")
                        .build())).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
