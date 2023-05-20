package com.hackathon.org.repository;

import com.hackathon.org.domain.BackgroundColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BackgroundColorRepository extends JpaRepository<BackgroundColor, Long> {

    @Override
    List<BackgroundColor> findAll();
}
