package com.data.dataproject.service;


import com.data.dataproject.domain.login.User;
import com.data.dataproject.dto.login.LoginDto;
import com.data.dataproject.dto.login.TokenDto;
import com.data.dataproject.repository.UserRepository;
import com.data.dataproject.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final KakaoService kakaoService;

    @Transactional
    public LoginDto login(TokenDto tokenDto) {

        LoginDto loginDto = new LoginDto();

        UserVo userVo = kakaoService.getSocialUserInfo(tokenDto);
        User user = userRepository.findBySocialId(userVo.getUserId());

        if (user == null) {
            User newUser = new User();

            newUser.setSocialId(userVo.getUserId());
            newUser.setName(userVo.getUserName());
            newUser.setProfileHref(userVo.getProfileHref());
            newUser.setPoint(0L);

            userRepository.save(newUser);

            final JwtService.TokenRes token = new JwtService.TokenRes(jwtService.create(newUser.getId()));
            loginDto.setToken(token.getToken());
//            loginDto.setId(newUser.getId()); //2명 이상일때 id값 제대로 오는지 확인하기
            final User user1 = userRepository.findBySocialId(userVo.getUserId());
            loginDto.setId(user1.getId());

            return loginDto;

        }

        final JwtService.TokenRes token = new JwtService.TokenRes(jwtService.create(user.getId()));

        loginDto.setToken(token.getToken());
        loginDto.setId(user.getId());
        return loginDto;
    }
}
