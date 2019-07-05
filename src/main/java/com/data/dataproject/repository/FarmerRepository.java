package com.data.dataproject.repository;

import com.data.dataproject.domain.main.FarmerWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<FarmerWord, String> {

//    @Query(value="select farmerImage, content from farmer_word", nativeQuery=true)
//    List<FarmerDto> findFarmerWord();

}
