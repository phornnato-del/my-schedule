package com.example.myschedulemysql.controller;


import com.example.myschedulemysql.dto.request.LoginReqDto;
import com.example.myschedulemysql.dto.request.UserRequestDto;
import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.response.user.LoginRespDto;
import com.example.myschedulemysql.dto.response.user.UserResponseDto;
import com.example.myschedulemysql.service.IUserService;
import com.example.myschedulemysql.service.jwt.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IUserService userService;
    private final ObjectMapper objectMapper;
    private final AuthService authService;


    @PostMapping("/login")
    public BaseWebResponse<LoginRespDto> login(@RequestBody LoginReqDto loginReqDto) {
        LoginRespDto loginRespDto = authService.login(loginReqDto);

        return BaseWebResponse.<LoginRespDto>builder()
                .status(200)
                .message("User login successfully")
                .data(loginRespDto)
                .build();

    }

    @PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BaseWebResponse<UserResponseDto> Register(
            @RequestPart("data") String data,
            @RequestPart(value = "image", required = false) MultipartFile file
    ) throws IOException {

        UserRequestDto request = objectMapper.readValue(data, UserRequestDto.class);

        return userService.Register(request, file);
    }

}
