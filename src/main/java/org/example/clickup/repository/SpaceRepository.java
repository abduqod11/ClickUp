package org.example.clickup.repository;

import org.example.clickup.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceRepository extends JpaRepository<Space,Long> {
    boolean existsByName(String name);
}
