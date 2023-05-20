package com.hackathon.org.repository;

import com.hackathon.org.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
