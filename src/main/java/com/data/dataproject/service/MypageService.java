package com.data.dataproject.service;

import com.data.dataproject.domain.login.User;
import com.data.dataproject.dto.DefaultRes;
import com.data.dataproject.dto.mypage.MypageDto;
import com.data.dataproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final UserRepository userRepository;

    public DefaultRes<MypageDto> getMapageInfo(Long id){
        Optional<User> user = userRepository.findById(id);

        MypageDto mypageDto = new MypageDto();
        mypageDto.setName(user.get().getName());
        mypageDto.setPoint(user.get().getPoint());

        return DefaultRes.res(200, "mypage 조회 성공", mypageDto);


    }
}
