package com.jagostinho.scheduler_app;

import java.time.LocalDateTime;
import java.util.Random;

import com.jagostinho.scheduler_api.domain.Task;
import com.jagostinho.scheduler_app.Scheduler.Scheduler;
import com.jagostinho.scheduler_app.Task.SchedulerCreateTask;

public class SchedulerMain {
    public static void main(String[] args) {

        // Create Task
        LocalDateTime date = LocalDateTime.now();
        Random random = new Random();

        Task task = new Task(
                date,
                date,
                date,
                date,
                "task" + random.nextInt(1000),
                "description1" + random.nextInt(1000),
                random.nextInt(10),
                true);

        // Create Scheduler
        Scheduler scheduler = new Scheduler(new SchedulerCreateTask("http://localhost:8080/api/v1/task", task));

        // Execute Scheduler
        scheduler.executeScheduler(2000, 15000);
    }
}
