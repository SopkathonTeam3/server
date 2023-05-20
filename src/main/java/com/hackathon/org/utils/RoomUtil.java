package com.hackathon.org.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RoomUtil {
    public static int calculateDateDifference(LocalDate createdAt) {
        int dateDifference = (int) ChronoUnit.DAYS.between(LocalDate.now(), createdAt);
        return Math.max(dateDifference, 0);
    }
}
