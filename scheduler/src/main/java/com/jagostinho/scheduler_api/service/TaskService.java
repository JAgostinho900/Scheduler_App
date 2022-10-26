package com.jagostinho.scheduler_api.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jagostinho.scheduler_api.dal.TaskRepository;
import com.jagostinho.scheduler_api.domain.Task;
import com.jagostinho.scheduler_api.dto.TaskDTO;
import com.jagostinho.scheduler_api.util.TaskMapper;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // Dependecy Injection
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Get all tasks
    public ResponseEntity<List<TaskDTO>> getTasks() {

        List<TaskDTO> tasksDTO = new ArrayList<TaskDTO>();
        List<Task> tasks = taskRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));

        tasks.forEach(x -> {
            tasksDTO.add(TaskMapper.toTaskDTO(x));
        });

        return new ResponseEntity<>(tasksDTO, HttpStatus.OK);
    }

    // Get task by id
    public ResponseEntity<TaskDTO> getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            return new ResponseEntity<>(TaskMapper.toTaskDTO(optionalTask.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Create task
    public ResponseEntity<TaskDTO> createTask(Task task) {
        return new ResponseEntity<>(TaskMapper.toTaskDTO(taskRepository.save(task)), HttpStatus.CREATED);
    }

    // Update task
    public ResponseEntity<TaskDTO> updateTask(Task task) {
        Optional<Task> optionalTask = taskRepository.findById(task.getId());
        if (optionalTask.isPresent()) {
            return new ResponseEntity<>(TaskMapper.toTaskDTO(taskRepository.save(task)), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Delete task
    public ResponseEntity<TaskDTO> deleteTask(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            taskRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
