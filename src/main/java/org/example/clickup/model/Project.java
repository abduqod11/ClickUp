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

public class Project extends AbsEntity {
    @Column(nullable = false)
    private String name;
    @OneToOne
    private Space SpaceId;
    @Column(nullable = false)
    private String accessType;
    @Column(nullable = false)
    private String archived;
    @Column(nullable = false)
    private String color;
}