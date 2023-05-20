package com.hackathon.org.service;

import com.hackathon.org.controller.dto.ReadBackgroundColorDTO;
import com.hackathon.org.repository.BackgroundColorRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BackgroundColorService {

    private final BackgroundColorRepository backgroundColorRepository;

    public List<ReadBackgroundColorDTO> getBackgroundColors() {
        return backgroundColorRepository
                .findAll()
                .stream()
                .map(ReadBackgroundColorDTO::from)
                .collect(Collectors.toList());
    }
}
