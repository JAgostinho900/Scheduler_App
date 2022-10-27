package com.jagostinho.scheduler_api;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jagostinho.scheduler_api.domain.Task;
import com.jagostinho.scheduler_api.scheduler.Scheduler;
import com.jagostinho.scheduler_api.scheduler.SchedulerCreateTask;

@SpringBootApplication
public class SchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerApplication.class, args);
		executeScheduler();
	}

	public static void executeScheduler() {

		// Create Task
		LocalDateTime date = LocalDateTime.now();
		Random random = new Random();

		Task task = new Task(
				date,
				date,
				date,
				date,
				"title" + random.nextInt(1000),
				"description" + random.nextInt(1000),
				random.nextInt(10),
				true);

		// Create Scheduler
		Scheduler scheduler = new Scheduler(new SchedulerCreateTask("http://localhost:8080/api/v1/task", task));

		// Execute Scheduler
		scheduler.executeScheduler(2000, 10000);
	}
}
