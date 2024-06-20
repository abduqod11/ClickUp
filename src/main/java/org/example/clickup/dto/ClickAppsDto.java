package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.clickup.model.Icon;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClickAppsDto {
    private String name;
    private Long IconId;
}
