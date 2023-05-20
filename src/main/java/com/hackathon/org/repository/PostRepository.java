package com.hackathon.org.repository;

import com.hackathon.org.domain.Post;
import com.hackathon.org.domain.Room;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByRoom(Room room);
}
