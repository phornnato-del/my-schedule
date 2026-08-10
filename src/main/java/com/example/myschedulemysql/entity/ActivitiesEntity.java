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
@Table(name = "activities")
public class ActivitiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ACTIVITY_NAME")
    private String activityName;

    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "DURATION_MINUTES")
    private Integer durationMinutes;

    @Column(name = "ACTIVITY_DATE")
    private LocalDate activityDate;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "CREATED_AT")
    private LocalDate createdAt;
}