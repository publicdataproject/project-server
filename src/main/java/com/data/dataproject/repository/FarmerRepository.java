package com.data.dataproject.repository;

import com.data.dataproject.domain.FarmerWord;
import com.data.dataproject.dto.main.FarmerDto;
import com.data.dataproject.dto.main.SeasonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FarmerRepository extends JpaRepository<FarmerWord, String> {

//    @Query(value="select farmerImage, content from farmer_word", nativeQuery=true)
//    List<FarmerDto> findFarmerWord();

}
