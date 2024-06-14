package org.example.clickup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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

public class WorkSpace extends AbsEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String color;
    @ManyToOne
    private User user;
    @Column(nullable = false)
    private String initialLetter;
    @OneToOne
    private Attachment avatarId;
}
