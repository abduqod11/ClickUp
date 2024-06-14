package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class IconDto {
    private Long AttachmentId;
    private String color;
    private String initialLetter;
    private String icon;
}