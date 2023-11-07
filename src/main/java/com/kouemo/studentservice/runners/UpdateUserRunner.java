package com.kouemo.studentservice.runners;

import com.kouemo.studentservice.feature.entities.User;
import com.kouemo.studentservice.feature.repositories.RoleRepository;
import com.kouemo.studentservice.feature.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UpdateUserRunner implements ApplicationRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<User> user = userRepository.findByUsername("SuperUser");
        if(user.isEmpty()){
            User superUser = User.builder()
                    .username("SuperUser")
                    .password(passwordEncoder.encode("password"))
                    .roles(roleRepository.findAll())
                    .build();
            userRepository.save(superUser);
        }else {
            user.get().setRoles(roleRepository.findAll());
        }
    }
}
