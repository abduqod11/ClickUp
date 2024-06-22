package org.example.clickup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.clickup.model.temporale.AbsEntity;
import org.example.clickup.model.temporale.Permission;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class WorkSpacePermission extends AbsEntity {
    @OneToOne
    private WorkSpaceRole WorkSpaceRoleId;
    @Column(nullable = false)
    private Permission Permission;
}