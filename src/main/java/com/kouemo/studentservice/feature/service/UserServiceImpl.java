package com.kouemo.studentservice.feature.service;

import com.kouemo.studentservice.feature.dtos.UserDto;
import com.kouemo.studentservice.feature.dtos.UserDtoInterface;
import com.kouemo.studentservice.feature.entities.Subject;
import com.kouemo.studentservice.feature.entities.User;
import com.kouemo.studentservice.feature.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserDto create(UserDto user) {
        User userToSave = UserDto.map(user);
        userRepository.save(userToSave);
        return user;
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
            userRepository.save(updatedUser);
        });
        throw new ObjectNotFoundException(Subject.class.getSimpleName(),userId);
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
