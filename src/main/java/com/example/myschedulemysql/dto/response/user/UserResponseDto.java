package com.example.myschedulemysql.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    private long id;
    private String userCode;
    private String username;
    private String telephone;
    private String status;
    private String image;
    private LocalDateTime createdAt;
}
