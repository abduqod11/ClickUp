package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class WorkSpaceUserDto {
    private Long workSpaceId;
    private Long userId;
    private Long workSpaceRole;
}