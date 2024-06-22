package org.example.clickup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.clickup.model.temporale.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class CheckListItem extends AbsEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long checklistId;
    @Column(nullable = false)
    private String resolved;
    @Column(nullable = false)
    private Long assignedUserId;
}