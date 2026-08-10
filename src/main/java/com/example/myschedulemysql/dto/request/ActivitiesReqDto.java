package com.example.myschedulemysql.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ActivitiesReqDto {

    private Long userId;

    private String activityName;

    private Integer categoryId;

    private Integer durationMinutes;

    private LocalDate activityDate;

    private String note;
}