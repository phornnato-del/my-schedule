package com.example.myschedulemysql.service;

import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.request.LoginReqDto;
import com.example.myschedulemysql.dto.response.user.UserResponseDto;
import com.example.myschedulemysql.dto.request.UserRequestDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IUserService {

    BaseWebResponse<UserResponseDto> Register(UserRequestDto request, MultipartFile file) throws IOException;

    String LoginUser(LoginReqDto request) throws IOException;

    BaseWebResponse<List<UserResponseDto>> getUsers() throws IOException;

    BaseWebResponse<UserResponseDto> getUserById(Long id);

    BaseWebResponse<UserResponseDto> Update(Long id, UserRequestDto request, MultipartFile file) throws IOException;

    BaseWebResponse<Void> Delete(Long id) throws IOException;

}
