package com.data.dataproject.repository;

import com.data.dataproject.domain.main.SeasonFruits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<SeasonFruits, String> {

}
