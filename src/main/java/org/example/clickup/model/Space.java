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

public class Space extends AbsEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String color;
    @OneToOne
    private WorkSpace workSpaceId;
    @Column(nullable = false)
    private String initialLetter;
    @OneToOne
    private Icon icon;
    @Column(nullable = false)
    private Long avatarId;
    @Column(nullable = false)
    private Long ownerId;
    @Column(nullable = false)
    private String accessType;
}