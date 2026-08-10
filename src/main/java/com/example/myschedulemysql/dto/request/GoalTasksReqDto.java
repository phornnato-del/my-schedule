package com.example.myschedulemysql.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class GoalTasksReqDto {

    private Long userId;

    private Long goalId;

    private String taskName;

    private Boolean completed;

    private LocalDate dueDate;

}
