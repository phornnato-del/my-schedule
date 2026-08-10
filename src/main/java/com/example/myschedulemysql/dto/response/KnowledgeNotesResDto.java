package com.example.myschedulemysql.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class KnowledgeNotesResDto {

    private Long id;

    private Long userId;

    private String title;

    private String content;

    private Integer categoryId;

    private String tags;

    private Boolean favorite;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}