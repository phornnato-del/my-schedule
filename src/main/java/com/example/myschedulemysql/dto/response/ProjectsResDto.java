package com.example.myschedulemysql.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProjectsResDto {

    private Long id;

    private Long userId;

    private String name;

    private String description;

    private String technology;

    private String status; // IDEA, DEVELOPMENT, COMPLETED, STOPPED

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer progress;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}