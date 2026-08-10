package com.example.myschedulemysql.dto.response.user;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRespDto {
    private Long id;
    private String username;
    private String image;
    private String telephone;
    private String status;
    private String token;
}
