package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.clickup.model.WorkSpace;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SpaceDto {
    private String name;
    private String color;
    private Long workSpaceId;
    private String initialLetter;
    private Long iconId;
    private Long avatarId;
    private Long ownerId;
    private String accessType;
}