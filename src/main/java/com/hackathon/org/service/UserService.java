package com.hackathon.org.service;

import com.hackathon.org.common.error.model.NotFoundException;
import com.hackathon.org.controller.dto.PostUserResponseDTO;
import com.hackathon.org.controller.dto.UserResponseDto;
import com.hackathon.org.domain.BackgroundColor;
import com.hackathon.org.domain.Room;
import com.hackathon.org.domain.User;
import com.hackathon.org.repository.BackgroundColorRepository;
import com.hackathon.org.repository.RoomRepository;
import com.hackathon.org.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.hackathon.org.common.status.ErrorStatus.NOT_FOUND;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BackgroundColorRepository backgroundColorRepository;
    private final RoomRepository roomRepository;

    public PostUserResponseDTO registerUser(String name, Long backgroundColorId) {
        BackgroundColor backgroundColor =
                backgroundColorRepository.findById(backgroundColorId).orElseThrow(IllegalArgumentException::new);

        User newUser = User.builder()
                .name(name)
                .backgroundColor(backgroundColor)
                .build();

        Long userId = userRepository.save(newUser).getUserId();

        Room newRoom = Room.builder()
                .user(newUser)
                .build();

        Long roomId = roomRepository.save(newRoom).getRoomId();

        return PostUserResponseDTO.from(userId, roomId);

    }

    public UserResponseDto findUser(final Long userId) {
        User user = findUserWithId(userId);
        userRepository.findAll().forEach(u -> System.out.println(user.getUserId()));
        return UserResponseDto.of(user);
    }

    private User findUserWithId(final Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException(NOT_FOUND));
    }
}
