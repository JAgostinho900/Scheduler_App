package com.jagostinho.scheduler_api.dal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.jagostinho.scheduler_api.domain.Task;

// Repository Design Pattern
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findTaskById(Long id);
}
