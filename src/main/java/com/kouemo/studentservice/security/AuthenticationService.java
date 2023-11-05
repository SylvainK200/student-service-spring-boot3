package com.kouemo.studentservice.security;

import com.kouemo.studentservice.security.request.SignInRequest;
import com.kouemo.studentservice.security.request.SignUpRequest;
import com.kouemo.studentservice.security.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
