package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StatusDto {
    private String name;
    private Long spaceId;
    private Long projectId;
    private Long categoryId;
    private String color;
}