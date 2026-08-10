package com.example.myschedulemysql.dto.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginReqDto {
    private String username;
    private String password;
}
