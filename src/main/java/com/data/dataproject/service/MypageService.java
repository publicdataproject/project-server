package com.data.dataproject.service;

import com.data.dataproject.domain.User;
import com.data.dataproject.dto.mypage.MypageDto;
import com.data.dataproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final UserRepository userRepository;

    public MypageDto getMapageInfo(Long id){
        Optional<User> user = userRepository.findById(id);


        MypageDto mypageDto = new MypageDto();
        mypageDto.setName(user.get().getName());
        mypageDto.setPoint(user.get().getPoint());

        return mypageDto;

    }
}
