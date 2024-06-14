package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class WorkSpaceDto {
    private String name;
    private String color;
    private Long userId;
    private String initialLetter;
    private Long avatarId;
}