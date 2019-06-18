package com.data.dataproject.service;


import com.data.dataproject.domain.User;
import com.data.dataproject.dto.TokenDto;
import com.data.dataproject.model.DefaultRes;
import com.data.dataproject.repository.UserRepository;
import com.data.dataproject.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final KakaoService kakaoService;

    @Transactional
    public DefaultRes<JwtService.TokenRes> login(TokenDto tokenDto) {

        UserVo userVo = kakaoService.getSocialUserInfo(tokenDto);

        User user = userRepository.findBySocialId(userVo.getUserId());

        if (user == null) {
            User newUser = new User();

            newUser.setSocialId(userVo.getUserId());
            newUser.setName(userVo.getUserName());
            newUser.setProfileHref(userVo.getProfileHref());

            userRepository.save(newUser);

            final JwtService.TokenRes token = new JwtService.TokenRes(jwtService.create(newUser.getId()));
            return DefaultRes.res(200, "로그인 성공", token);

        }

        final JwtService.TokenRes token = new JwtService.TokenRes(jwtService.create(user.getId()));
        return DefaultRes.res(200, "로그인 성공", token);
    }
}
