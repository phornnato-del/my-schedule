package com.example.myschedulemysql.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class GoalsResDto {

    private Long id;

    private Long userId;

    private String title;

    private String description;

    private Integer categoryId;

    private LocalDate startDate;

    private LocalDate targetDate;

    private Integer priorityId;

    private Integer statusId;

    private Integer progress;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}