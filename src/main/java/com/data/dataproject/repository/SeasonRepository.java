package com.data.dataproject.repository;

import com.data.dataproject.domain.SeasonFruits;
import com.data.dataproject.dto.main.SeasonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SeasonRepository extends JpaRepository<SeasonFruits, String> {
//
//    @Query(value="select fruitsImage, fruitsName from season_fruits", nativeQuery=true)
//    List<SeasonDto> findFruits();
}
