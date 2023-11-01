package com.kouemo.studentservice.feature.service;

import com.kouemo.studentservice.feature.dtos.ExaminationRecord;
import com.kouemo.studentservice.feature.dtos.SubjectRecord;
import com.kouemo.studentservice.feature.dtos.UserRecord;
import com.kouemo.studentservice.feature.entities.Examination;
import com.kouemo.studentservice.feature.entities.Subject;
import com.kouemo.studentservice.feature.entities.User;
import com.kouemo.studentservice.feature.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserRecord create(UserRecord user) {
        User userToSave = UserRecord.map(user);
        userRepository.save(userToSave);
        return user;
    }

    @Override
    public UserRecord findById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(UserRecord::map).orElse(null);
    }

    @Override
    public UserRecord update(UserRecord user, Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        optionalUser.ifPresent(exam->{
            User updatedUser = UserRecord.map(user);
            updatedUser.setId(userId);
            userRepository.save(updatedUser);
        });
        throw new ObjectNotFoundException(Subject.class.getSimpleName(),userId);
    }

    @Override
    public Page<UserRecord> findAllBySearch(int page, int size, String search, String columnSort) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(columnSort));
        Page<UserRecord> result = userRepository.findAllBySearch(search,pageable);
        return result;
    }

    @Override
    public UserRecord delete(Long userId) {
        return null;
    }
}
