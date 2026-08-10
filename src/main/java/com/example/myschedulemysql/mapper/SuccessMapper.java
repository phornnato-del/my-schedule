package com.example.myschedulemysql.mapper;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SuccessMapper {
    private int code;
    private String message;
    private Object data;
}
