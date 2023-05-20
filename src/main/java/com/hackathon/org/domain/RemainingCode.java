package com.hackathon.org.domain;

import static com.hackathon.org.common.status.ErrorStatus.NOT_FOUND;

import com.hackathon.org.common.error.model.NotFoundException;
import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RemainingCode {

    CODE_ONE(-1, 0, 1), CODE_TWO(-2, 2, 3), CODE_THREE(-3, 4, 5), CODE_FOUR(-4, 6, 7);

    private final int remainingCodeNumber;
    private final int minDifferenceRange;
    private final int maxDifferenceRange;

    private static final int EXPIRATION_DATE_MAX_RANGE = 7;
    private static final int EXPIRATION_DATE_MIN_RANGE = 0;

    // TODO : 추후 예외처리
    private static RemainingCode getRemainingCodeWithDateDifference(final int dateDifference) {
        return Arrays.stream(values())
                .filter(v -> v.maxDifferenceRange == dateDifference || v.minDifferenceRange == dateDifference)
                .findFirst().orElseThrow(() -> new NotFoundException(NOT_FOUND));
    }

    private static int clamp(int dateDifference) {
        if (dateDifference > EXPIRATION_DATE_MAX_RANGE) {
            return EXPIRATION_DATE_MAX_RANGE;
        }
        return Math.max(dateDifference, EXPIRATION_DATE_MIN_RANGE);
    }

    public static int getRemainingCodeNumberWithDateDifference(final int dateDifference) {
        return getRemainingCodeWithDateDifference(clamp(dateDifference)).getRemainingCodeNumber();
    }
}
