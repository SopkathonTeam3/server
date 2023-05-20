package com.hackathon.org.controller.dto;

import com.hackathon.org.domain.BackgroundColor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ReadBackgroundColorResponseDTO {
    private final Long backgroundColorId;
    private final String backgroundColorCode;

    public static ReadBackgroundColorResponseDTO from (BackgroundColor backgroundColor) {
        return new ReadBackgroundColorResponseDTO(
                backgroundColor.getBackgroudColorId(),
                backgroundColor.getBackgroudColorCode()
        );
    }
}
