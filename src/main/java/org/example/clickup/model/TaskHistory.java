package org.example.clickup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.clickup.model.temporale.AbsEntity;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class TaskHistory extends AbsEntity {
    @OneToOne
    private Task TaskId;
    @Column(nullable = false)
    private String changeFieldName;
    private Timestamp before;
    private Timestamp after;
    private Timestamp data;
}