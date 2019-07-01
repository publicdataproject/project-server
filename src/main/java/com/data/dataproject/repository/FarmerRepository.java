package com.data.dataproject.repository;

import com.data.dataproject.domain.FarmerWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmerRepository extends JpaRepository<FarmerWord, String> {
    List<FarmerWord> findAll();
}
