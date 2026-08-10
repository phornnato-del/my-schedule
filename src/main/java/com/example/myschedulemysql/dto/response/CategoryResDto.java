package com.example.myschedulemysql.dto.response;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResDto {
    private Long id;
    private String title;
    private String description;
    private String type;
}
