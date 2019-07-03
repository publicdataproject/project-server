package com.data.dataproject.repository;


import com.data.dataproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findBySocialId(Long socialId);

}
