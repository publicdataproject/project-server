package com.data.dataproject.repository;

import com.data.dataproject.domain.SeasonFruits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRepository extends JpaRepository<SeasonFruits, String> {
    List<SeasonFruits> findAll();
}
