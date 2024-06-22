package org.example.clickup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
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

public class WorkSpaceRole extends AbsEntity {
    @OneToOne
    private WorkSpace WorkSpaceId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String extendsRole;
}