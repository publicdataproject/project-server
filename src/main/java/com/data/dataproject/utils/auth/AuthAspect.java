package com.data.dataproject.utils.auth;

import com.data.dataproject.domain.User;
import com.data.dataproject.repository.UserRepository;
import com.data.dataproject.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
@Aspect
@RequiredArgsConstructor
public class AuthAspect {

    private final static String AUTHORIZATION = "Authorization";

    private final static ResponseEntity RES_RESPONSE_ENTITY = new ResponseEntity<>(401, HttpStatus.UNAUTHORIZED);

    private final HttpServletRequest httpServletRequest;

    private final UserRepository userRepository;

    private final JwtService jwtService;


    @Transactional
    @Around("@annotation(com.data.dataproject.utils.auth.Auth)")
    public Object around(final ProceedingJoinPoint pjp) throws Throwable {
        final String jwt = httpServletRequest.getHeader(AUTHORIZATION);

        if (jwt == null) return RES_RESPONSE_ENTITY;

        final JwtService.Token token = jwtService.decode(jwt);

        if (token == null) {
            return RES_RESPONSE_ENTITY;
        } else {
            final User user = userRepository.findUserById(token.getUser_idx());

            if (user == null) return RES_RESPONSE_ENTITY;
            return pjp.proceed(pjp.getArgs());
        }
    }
}
