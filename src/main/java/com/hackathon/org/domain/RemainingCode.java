package com.hackathon.org.domain;

import com.hackathon.org.common.error.model.NotFoundException;
import com.hackathon.org.utils.RoomUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import static com.hackathon.org.common.status.ErrorStatus.INVALID_DATE_DIFFERENCE;

@Getter
@RequiredArgsConstructor
public enum RemainingCode {

    CODE_ONE(-1, 0, 1), CODE_TWO(-2, 2, 3), CODE_THREE(-3, 4, 5), CODE_FOUR(-4, 6, 7);

    private final int remainingCodeNumber;
    private final int minDifferenceRange;
    private final int maxDifferenceRange;

    private static RemainingCode getRemainingCodeWithDateDifference(final long dateDifference) {
        return Arrays.stream(values())
                .filter(v -> v.maxDifferenceRange == dateDifference || v.minDifferenceRange == dateDifference)
                .findFirst().orElseThrow(() -> new NotFoundException(INVALID_DATE_DIFFERENCE));
    }

    public static int getRemainingCodeNumber(final long dateDifference) {
        return getRemainingCodeWithDateDifference(RoomUtil.clampDateRange(dateDifference)).getRemainingCodeNumber();
    }
}
