package com.example.myschedulemysql.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProjectTasksReqDto {

    private Long userId;

    private Long projectId;

    private String title;

    private String description;

    private Integer priorityId;

    private Integer statusId;

    private LocalDate dueDate;
}