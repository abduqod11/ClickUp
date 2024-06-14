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

public class Icon extends AbsEntity {
    @OneToOne
    private Attachment AttachmentId;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String initialLetter;
    @Column(nullable = false)
    private String icon;
}
