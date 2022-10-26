package com.jagostinho.scheduler_api.util;

import com.jagostinho.scheduler_api.domain.Task;
import com.jagostinho.scheduler_api.dto.TaskDTO;

public class TaskMapper {
    public static TaskDTO toTaskDTO(Task task) {

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setCreatedAt(task.getCreatedAt());
        taskDTO.setUpdatedAt(task.getUpdatedAt());
        taskDTO.setDueDate(task.getDueDate());
        taskDTO.setResolvedAt(task.getResolvedAt());
        taskDTO.setPriority(task.getPriority());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setStatus(task.getStatus());

        return taskDTO;
    }
}
