package com.data.dataproject.repository;

import com.data.dataproject.domain.main.SeasonFruits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<SeasonFruits, String> {
//
//    @Query(value="select fruitsImage, fruitsName from season_fruits", nativeQuery=true)
//    List<SeasonDto> findFruits();
}
