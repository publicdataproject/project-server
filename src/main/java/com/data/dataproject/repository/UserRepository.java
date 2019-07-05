package com.data.dataproject.repository;


import com.data.dataproject.domain.login.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findBySocialId(Long socialId);

}
