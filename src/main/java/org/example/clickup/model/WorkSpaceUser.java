package org.example.clickup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.clickup.model.temporale.AbsEntity;
import java.sql.Timestamp;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class WorkSpaceUser extends AbsEntity {
    @OneToMany
    private List<WorkSpace> workSpaceId;
    @OneToMany
    private List<User> userId;
    @OneToMany
    private List<WorkSpaceRole> workSpaceRoleId;
    private Timestamp dataInvited;
    private Timestamp dataJoined;
}