package com.hackathon.org.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RoomUtil {
    private static final int EXPIRATION_PERIOD = 7;
    private static final int DATE_DIFFERENCE_MIN_RANGE = 0;

    public static long calculateDateDifference(LocalDate createdAt) {
        return ChronoUnit.DAYS.between(LocalDate.now(),
                createdAt.plus(EXPIRATION_PERIOD, ChronoUnit.DAYS));
    }

    public static long clampDateRange(long dateDifference) {
        if (dateDifference > EXPIRATION_PERIOD) {
            return EXPIRATION_PERIOD;
        }
        if (dateDifference < DATE_DIFFERENCE_MIN_RANGE) {
            return DATE_DIFFERENCE_MIN_RANGE;
        }
        return dateDifference;
    }
}
