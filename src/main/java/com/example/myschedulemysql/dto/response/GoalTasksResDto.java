package com.example.myschedulemysql.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class GoalTasksResDto {

    private Long id;

    private Long userId;

    private Long goalId;

    private String taskName;

    private Boolean completed;

    private LocalDate dueDate;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}
