package com.jagostinho.scheduler_app;

import java.time.LocalDateTime;

import com.jagostinho.scheduler_api.domain.Task;
import com.jagostinho.scheduler_app.Task.SchedulerCreateTask;

public class SchedulerMain {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.of(2022, 10, 26, 10, 0, 0);
        Task task = new Task(
                date,
                date,
                date,
                date,
                "task1",
                "description1",
                1,
                true);

        Scheduler scheduler = new Scheduler(new SchedulerCreateTask("http://localhost:8080/api/v1/task", task));
        scheduler.executeScheduler(2000, 15000);
    }
}
