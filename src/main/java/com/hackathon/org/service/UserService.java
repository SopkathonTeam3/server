package com.hackathon.org.service;

import static com.hackathon.org.common.status.ErrorStatus.NOT_FOUND;

import com.hackathon.org.common.error.model.NotFoundException;
import com.hackathon.org.controller.dto.UserResponseDto;
import com.hackathon.org.domain.User;
import com.hackathon.org.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto findUser(final Long userId) {
        User user = findUserWithId(userId);
        userRepository.findAll().forEach(u -> System.out.println(user.getUserId()));
        return UserResponseDto.of(user);
    }

    private User findUserWithId(final Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException(NOT_FOUND));
    }
}
