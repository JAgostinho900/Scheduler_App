package com.jagostinho.scheduler.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jagostinho.scheduler.business.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
