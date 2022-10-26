package com.jagostinho.scheduler_api.dto;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TaskDTO {

    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime dueDate;

    private LocalDateTime resolvedAt;

    private String title;

    private String description;

    private Integer priority;

    private Boolean status;
}
