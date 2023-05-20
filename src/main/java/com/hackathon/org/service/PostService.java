package com.hackathon.org.service;

import com.hackathon.org.controller.dto.SinglePostResponseDto;
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

    private List<SinglePostResponseDto> findAllPosts(final Room room) {
        List<Post> posts = postRepository.findAllByRoom(room);
        return posts.stream()
                .map(SinglePostResponseDto::of)
                .collect(Collectors.toList());
    }
}
