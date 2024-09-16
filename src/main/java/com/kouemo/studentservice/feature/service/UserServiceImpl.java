package com.kouemo.studentservice.feature.service;

import com.kouemo.studentservice.feature.dtos.UserDto;
import com.kouemo.studentservice.feature.dtos.UserDtoInterface;
import com.kouemo.studentservice.feature.entities.Subject;
import com.kouemo.studentservice.feature.entities.User;
import com.kouemo.studentservice.feature.repositories.UserRepository;
import com.kouemo.studentservice.generics.exceptions.feature_exception.UserExistException;
import com.kouemo.studentservice.generics.exceptions.feature_exception.UserNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto create(UserDto user) {
        User userToSave = UserDto.map(user);
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if(optionalUser.isEmpty()){
            userToSave.setPassword(passwordEncoder.encode(userToSave.getPassword()));
            userRepository.save(userToSave);
            return user;
        }
       throw  new UserExistException("Utilisateur existant","null");
    }

    @Override
    public UserDto findById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(UserDto::map).orElse(null);
    }

    @Override
    public UserDto update(UserDto user, Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        optionalUser.ifPresent(exam->{
            User updatedUser = UserDto.map(user);
            updatedUser.setId(userId);
            updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            userRepository.save(updatedUser);
        });
        throw new UserNotFoundException(Subject.class.getSimpleName(),userId.toString(),"User not found");
    }

    @Override
    public Page<UserDto> findAllBySearch(int page, int size, String search, String columnSort) {
        Pageable pageable = PageRequest.of(page,size);
        Page<UserDtoInterface> result = userRepository.findAllBySearch(search,pageable);
        List<UserDto> content = result.getContent().stream().map(UserDto::map).toList();
        return new PageImpl<>(content,pageable,result.getTotalElements());
    }

    @Override
    public UserDto delete(Long userId) {
        return null;
    }
}
