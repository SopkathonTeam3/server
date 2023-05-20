package com.hackathon.org.controller.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostUserRequestDTO {
    @NotNull
    private final String name;
    @NotNull
    private final Long backgroundColorId;
}
