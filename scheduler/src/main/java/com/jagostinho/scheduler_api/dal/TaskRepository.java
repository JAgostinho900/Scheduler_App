package com.jagostinho.scheduler_api.dal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jagostinho.scheduler_api.business.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Repository Pattern

    Optional<Task> findTaskById(Long id);
}
