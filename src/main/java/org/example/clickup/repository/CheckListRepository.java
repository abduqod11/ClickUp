package org.example.clickup.repository;

import org.example.clickup.model.CheckList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckListRepository extends JpaRepository<CheckList, Long> {
}