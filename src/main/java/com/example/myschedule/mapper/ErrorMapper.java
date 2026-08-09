package com.example.myschedule.mapper;

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
