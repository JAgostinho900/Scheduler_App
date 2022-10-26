package com.jagostinho.scheduler_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import com.jagostinho.scheduler_api.business.Task;
import com.jagostinho.scheduler_api.dal.TaskRepository;
import javax.persistence.*;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            return optionalTask.get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, String.format("task with the id '%d' not found", id));
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Task task) {
        Optional<Task> optionalTask = taskRepository.findById(task.getId());
        if (optionalTask.isPresent()) {
            taskRepository.save(task);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("task with the id '%d' not found", task.getId()));
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
