package com.jagostinho.scheduler_api.business;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    // #region Properties

    // @Id
    // @SequenceGenerator(name = "task_sequence", sequenceName = "task_sequence",
    // allocationSize = 1)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
    // "task_sequence")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date createdAt;
    @Column
    private Date updatedAt;
    @Column
    private Date dueDate;
    @Column
    private Date resolvedAt;
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

    // public Task() {

    // }

    public Task(Long id, Date createdAt, Date updatedAt, Date dueDate, Date resolvedAt, String title,
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

    public Task(Date createdAt, Date updatedAt, Date dueDate, Date resolvedAt, String title,
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

    // #region Getters and Setters

    // #region Id

    // public Long getId() {
    // return id;
    // }

    // public void setId(Long id) {
    // this.id = id;
    // }

    // // #endregion

    // // #region CreatedAt

    // public Date getCreatedAt() {
    // return createdAt;
    // }

    // public void setCreatedAt(Date createdAt) {
    // this.createdAt = createdAt;
    // }

    // // #endregion

    // // #region UpdatedAt

    // public Date getUpdatedAt() {
    // return updatedAt;
    // }

    // public void setUpdatedAt(Date updatedAt) {
    // this.updatedAt = updatedAt;
    // }

    // // #endregion

    // // #region DueDate

    // public Date getDueDate() {
    // return dueDate;
    // }

    // public void setDueDate(Date dueDate) {
    // this.dueDate = dueDate;
    // }

    // // #endregion

    // // #region ResolvedAt

    // public Date getResolvedAt() {
    // return resolvedAt;
    // }

    // public void setResolvedAt(Date resolvedAt) {
    // this.resolvedAt = resolvedAt;
    // }

    // // #endregion

    // // #region Title

    // public String getTitle() {
    // return title;
    // }

    // public void setTitle(String title) {
    // this.title = title;
    // }

    // // #endregion

    // // #region Description

    // public String getDescription() {
    // return description;
    // }

    // public void setDescription(String description) {
    // this.description = description;
    // }

    // // #endregion

    // // #region Priority

    // public Integer getPriority() {
    // return priority;
    // }

    // public void setPriority(Integer priority) {
    // this.priority = priority;
    // }

    // // #endregion

    // // #region Status

    // public Boolean getStatus() {
    // return status;
    // }

    // public void setStatus(Boolean status) {
    // this.status = status;
    // }

    // #endregion

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
