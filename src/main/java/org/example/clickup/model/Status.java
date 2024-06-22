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

public class Status extends AbsEntity {
    @Column(nullable = false)
    private String name;
    @OneToOne
    private Space SpaceId;
    @OneToOne
    private Project ProjectId;
    @OneToOne
    private Category CategoryId;
    @Column(nullable = false)
    private String color;
}