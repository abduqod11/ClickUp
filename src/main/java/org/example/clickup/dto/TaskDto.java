package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TaskDto {
    private String name;
    private String description;
    private Long StatusId;
    private Long CategoryId;
    private Long PriorityId;
    private Long ParentTaskId;
    private Long estimateTime;
}