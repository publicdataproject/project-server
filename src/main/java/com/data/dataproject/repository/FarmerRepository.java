package com.data.dataproject.repository;

import com.data.dataproject.domain.main.FarmerWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<FarmerWord, String> {

}
