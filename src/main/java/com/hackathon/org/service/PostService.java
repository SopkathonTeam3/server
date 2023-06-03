package com.hackathon.org.service;

import com.hackathon.org.controller.dto.*;
import com.hackathon.org.domain.Post;
import com.hackathon.org.domain.Room;
import com.hackathon.org.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final RoomService roomService;
    private final UserService userService;

    public PostListResponseDto getPosts(Long userId, Long roomId) {
        Room room = roomService.findRoomWithId(roomId);
        RoomResponseDto roomResponseDto = RoomResponseDto.of(room);
        List<SinglePostResponseDto> posts = findAllPostsWithRoom(room);
        UserResponseDto userResponseDto = userService.findUser(userId);
        return new PostListResponseDto(roomResponseDto, userResponseDto, posts);
    }

    private List<SinglePostResponseDto> findAllPostsWithRoom(final Room room) {
        List<Post> posts = postRepository.findAllByRoom(room);
        return posts.stream().map(SinglePostResponseDto::of).collect(Collectors.toList());
    }

    @Transactional
    public void register(final Long userId, final Long roomId, final PostRegisterDto registerDto) {
        userService.findUser(userId);
        Room room = roomService.findRoomWithId(roomId);
        Post post = Post.builder()
                .room(room)
                .firstAnswer(registerDto.getFirstAnswer())
                .secondAnswer(registerDto.getSecondAnswer())
                .build();
        postRepository.save(post);
    }
}
