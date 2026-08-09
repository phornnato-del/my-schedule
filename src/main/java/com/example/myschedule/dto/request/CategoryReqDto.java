package com.example.myschedule.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryReqDto {
    private Long id;
    private String title;
    private String description;
    private String type;
}
