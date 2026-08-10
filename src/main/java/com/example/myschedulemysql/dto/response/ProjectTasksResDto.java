package com.example.myschedulemysql.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProjectTasksResDto {

    private Long id;

    private Long userId;

    private Long projectId;

    private String title;

    private String description;

    private Integer priorityId;

    private Integer statusId;

    private LocalDate dueDate;

    private LocalDate createdAt;
}
