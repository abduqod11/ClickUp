package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProjectDto {
    private String name;
    private Long spaceId;
    private String accessType;
    private String archived;
    private String color;
}