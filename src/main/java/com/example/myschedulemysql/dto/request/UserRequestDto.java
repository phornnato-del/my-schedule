package com.example.myschedulemysql.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {
    private Long id;
    private String username;
    private String password;
    private String telephone;
    private String image;
    private String status;
    private String createdAt;
    private String createdBy;
    private String updatedAt;
}
