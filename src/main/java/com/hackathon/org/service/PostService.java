package com.hackathon.org.service;

import com.hackathon.org.controller.dto.PostListResponseDto;
import com.hackathon.org.controller.dto.RoomResponseDto;
import com.hackathon.org.controller.dto.SinglePostResponseDto;
import com.hackathon.org.controller.dto.UserResponseDto;
import com.hackathon.org.domain.Post;
import com.hackathon.org.domain.Room;
import com.hackathon.org.repository.PostRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final RoomService roomService;
    private final UserService userService;

    public PostListResponseDto getPosts(Long userId, Long roomId) {
        Room room = roomService.findRoomWithId(roomId);
        RoomResponseDto roomResponseDto = RoomResponseDto.of(room);
        System.out.println("룸 성공");
        List<SinglePostResponseDto> posts = findAllPostsWithRoom(room);
        System.out.println("포스트 성공");
        UserResponseDto userResponseDto = userService.findUser(userId);
        System.out.println("유저 성공");
        return new PostListResponseDto(roomResponseDto, userResponseDto, posts);
    }

    private List<SinglePostResponseDto> findAllPostsWithRoom(final Room room) {
        List<Post> posts = postRepository.findAllByRoom(room);
        return posts.stream().map(SinglePostResponseDto::of).collect(Collectors.toList());
    }
}
