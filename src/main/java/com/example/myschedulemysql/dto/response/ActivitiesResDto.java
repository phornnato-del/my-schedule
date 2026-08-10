package com.example.myschedulemysql.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ActivitiesResDto {

    private Long id;

    private Long userId;

    private String activityName;

    private Integer categoryId;

    private Integer durationMinutes;

    private LocalDate activityDate;

    private String note;

    private LocalDate createdAt;
}