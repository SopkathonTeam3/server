package com.hackathon.org.controller.dto;

import com.hackathon.org.domain.RemainingCode;
import com.hackathon.org.domain.Room;
import com.hackathon.org.utils.RoomUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class RoomResponseDto {
    private Long roomId;
    private boolean isPublic;
    private long remainingDays;
    private int remainingCode;

    public static RoomResponseDto of(Room room) {
        long dateDifference = RoomUtil.calculateDateDifference(room.getCreatedAt());
        return RoomResponseDto.builder().roomId(room.getRoomId()).isPublic(dateDifference <= 0)
                .remainingDays(dateDifference)
                .remainingCode(RemainingCode.getRemainingCodeNumber(dateDifference)).build();

    }
}
