package com.kouemo.studentservice.security.authentication;

import com.kouemo.studentservice.feature.entities.User;
import com.kouemo.studentservice.security.request.SignInRequest;
import com.kouemo.studentservice.security.request.SignUpRequest;
import com.kouemo.studentservice.security.response.JwtAuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import java.io.IOException;

public interface AuthenticationService extends LogoutHandler {
    JwtAuthenticationResponse signin(SignInRequest request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
