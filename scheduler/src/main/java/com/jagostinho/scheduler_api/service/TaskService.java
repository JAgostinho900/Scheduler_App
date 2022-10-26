package com.jagostinho.scheduler_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import com.jagostinho.scheduler_api.dal.TaskRepository;
import com.jagostinho.scheduler_api.domain.Task;

import javax.persistence.*;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // Dependecy Injection
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Get all tasks
    public ResponseEntity<List<Task>> getTasks() {
        return new ResponseEntity<>(taskRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")), HttpStatus.OK);
    }

    // Get task by id
    public ResponseEntity<Task> getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Create task
    public ResponseEntity<Task> createTask(Task task) {
        return new ResponseEntity<>(taskRepository.save(task), HttpStatus.CREATED);
    }

    // Update task
    public ResponseEntity<Task> updateTask(Task task) {
        Optional<Task> optionalTask = taskRepository.findById(task.getId());
        if (optionalTask.isPresent()) {
            return new ResponseEntity<>(taskRepository.save(task), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Delete task
    public ResponseEntity<Task> deleteTask(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            taskRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
