package com.example.myschedulemysql.mapper;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorMapper {
    private int code;
    private String message;
}
