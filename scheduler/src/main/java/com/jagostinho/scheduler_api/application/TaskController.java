package com.jagostinho.scheduler_api.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.jagostinho.scheduler_api.domain.Task;
import com.jagostinho.scheduler_api.dto.TaskDTO;
import com.jagostinho.scheduler_api.service.TaskService;

@RestController
@RequestMapping(path = "api/v1/task")
public class TaskController {

    private final TaskService taskService;

    // Dependency Injection
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Get all tasks
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getTasks() {
        return taskService.getTasks();
    }

    // Get a single task by id
    @GetMapping
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    // Creates a single task
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // Updates a single task
    @PutMapping
    public ResponseEntity<TaskDTO> updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    // Deletes a single task
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TaskDTO> deleteTask(@PathVariable("id") Long id) {
        return taskService.deleteTask(id);
    }
}
