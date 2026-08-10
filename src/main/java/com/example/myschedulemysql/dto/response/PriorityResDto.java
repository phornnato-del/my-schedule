package com.example.myschedulemysql.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PriorityResDto {

    private Integer id;

    private String title;

    private String description;
}