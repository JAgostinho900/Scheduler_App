package com.jagostinho.scheduler_api.domain;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    // #region Properties

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;
    @Column
    private LocalDateTime dueDate;
    @Column
    private LocalDateTime resolvedAt;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Integer priority;
    @Column
    private Boolean status;

    // #endregion

    // #region Constructors

    public Task(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime dueDate,
            LocalDateTime resolvedAt, String title,
            String description, Integer priority, Boolean status) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.dueDate = dueDate;
        this.resolvedAt = resolvedAt;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public Task(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime dueDate, LocalDateTime resolvedAt,
            String title,
            String description, int priority, boolean status) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.dueDate = dueDate;
        this.resolvedAt = resolvedAt;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    // #endregion

    // #region ToString

    // Have a date format (dd/MM/yyyy)
    public String toString() {
        return "TaskModel{" + "id=" + id +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", resolvedAt='" + resolvedAt + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", status=" + status + '}';
    }

    // #endregion
}
