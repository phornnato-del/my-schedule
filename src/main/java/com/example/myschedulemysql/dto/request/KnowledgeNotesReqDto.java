package com.example.myschedulemysql.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KnowledgeNotesReqDto {

    private Long userId;

    private String title;

    private String content;

    private Integer categoryId;

    private String tags;

    private Boolean favorite;
}