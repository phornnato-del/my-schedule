package com.example.myschedulemysql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goals")
public class GoalsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "TARGET_DATE")
    private LocalDate targetDate;

    @Column(name = "PRIORITY_ID")
    private Integer priorityId;

    @Column(name = "STATUS_ID")
    private Integer statusId;

    @Column(name = "PROGRESS")
    private Integer progress;

    @Column(name = "CREATED_AT")
    private LocalDate createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDate updatedAt;
}