package com.example.myschedulemysql.service.jwt;

import com.example.myschedulemysql.dao.UserDao;
import com.example.myschedulemysql.dto.request.LoginReqDto;
import com.example.myschedulemysql.dto.response.user.LoginRespDto;
import com.example.myschedulemysql.entity.UserEntity;
import com.example.myschedulemysql.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDao userDao;

    public LoginRespDto login(LoginReqDto request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails user = (UserDetails) authentication.getPrincipal();

        UserEntity dbUser = userDao
                .findByUsername(user.getUsername())
                .orElseThrow();

        String token = jwtService.generateToken(user);

        return LoginRespDto.builder()
                .id(dbUser.getId())
                .username(user.getUsername())
                .image(ImageUtil.getImage(dbUser.getImage()))
                .telephone(dbUser.getTelephone())
                .status(dbUser.getStatus())
                .token(token)
                .build();
    }
}