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

public class Task extends AbsEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @OneToOne
    private Status StatusId;
    @OneToOne
    private Category CategoryId;
    @OneToOne
    private Priority PriorityId;
    @Column(nullable = false)
    private Long ParentTaskId;
    private Timestamp StartedDate;
    private Timestamp StartTimeHas;
    private Timestamp dueDate;
    private Timestamp dueTimeHas;
    @Column(nullable = false)
    private Long estimateTime;
    private Timestamp activeDDate;
}