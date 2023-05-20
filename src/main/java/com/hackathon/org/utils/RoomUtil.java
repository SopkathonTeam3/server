package com.hackathon.org.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RoomUtil {

    private static final int EXPIRED_DURATION = 7;

    public static int calculateDateDifference(LocalDate createdAt) {
        int dateDifference = (int) ChronoUnit.DAYS.between(LocalDate.now(),
                createdAt.plus(EXPIRED_DURATION, ChronoUnit.DAYS));
        return Math.max(dateDifference, 0);
    }
}
