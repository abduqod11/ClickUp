package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CheckListItemDto {
    private String name;
    private Long checklistId;
    private String resolved;
    private Long assignedUserId;
}