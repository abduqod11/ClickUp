package org.example.clickup.repository;

import org.example.clickup.model.WorkSpace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkSpaceRepository extends JpaRepository<WorkSpace,Long> {
    boolean existsByName(String name);
}