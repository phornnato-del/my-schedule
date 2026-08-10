package com.example.myschedulemysql.controller;

import com.example.myschedulemysql.dto.request.UserRequestDto;
import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.response.user.UserResponseDto;
import com.example.myschedulemysql.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user/v1/")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;
    private final ObjectMapper objectMapper;

    @GetMapping("/users")
    public BaseWebResponse<List<UserResponseDto>> GetUsers() throws IOException {
        return  userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public BaseWebResponse<UserResponseDto> getUserById(@PathVariable Long id) throws IOException {
        return  userService.getUserById(id);
    }

    @PostMapping(value = "/update/users/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BaseWebResponse<UserResponseDto> Update(
            @PathVariable Long id,
            @RequestPart("data") String data,
            @RequestPart(value = "image", required = false) MultipartFile file
    ) throws IOException {

        UserRequestDto request = objectMapper.readValue(data, UserRequestDto.class);

        return userService.Update(id, request, file);
    }

    @PostMapping("/delete/users/{id}")
    public BaseWebResponse<Void> Delete(@PathVariable Long id) throws IOException {
        return userService.Delete(id);
    }
}
