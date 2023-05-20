package com.hackathon.org.service;

import static com.hackathon.org.common.status.ErrorStatus.NOT_FOUND;

import com.hackathon.org.common.error.model.NotFoundException;
import com.hackathon.org.controller.dto.RoomResponseDto;
import com.hackathon.org.domain.Room;
import com.hackathon.org.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomResponseDto findRoom(final Long roomId) {
        Room room = findRoomWithId(roomId);
        return RoomResponseDto.of(room);
    }

    public Room findRoomWithId(final Long roomId) {
        return roomRepository.findById(roomId).orElseThrow(() -> new NotFoundException(NOT_FOUND));
    }
}
