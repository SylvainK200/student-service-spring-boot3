package com.kouemo.studentservice.runners;

import com.kouemo.studentservice.feature.entities.Role;
import com.kouemo.studentservice.feature.repositories.RoleRepository;
import com.kouemo.studentservice.feature.repositories.UserRepository;
import com.kouemo.studentservice.generics.enums.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UpdateRoles implements ApplicationRunner {
    private final RoleRepository roleRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Role> roles = roleRepository.findAll();
        Map<String,Role> roleMap = roles.stream().collect(Collectors.toMap(
                Role::getKey,
                role -> role
        ));
        RoleEnum roleEnums[] = RoleEnum.values();
        List<Role> rolesToSave = new ArrayList<>();
        for (RoleEnum role  : roleEnums ){
            if(roleMap.containsKey(role.getKey())){
                if (!roleMap.get(role.getKey()).getDescription().equals(role.getDescription())){
                    rolesToSave.add(roleMap.get(role.getKey()));
                }
            }else{
                rolesToSave.add(Role.builder()
                                .key(role.getKey())
                                .description(role.getDescription())
                        .build());
            }
        }
        roleRepository.saveAll(rolesToSave);
    }
}
