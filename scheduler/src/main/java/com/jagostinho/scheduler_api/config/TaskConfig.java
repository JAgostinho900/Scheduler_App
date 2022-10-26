package com.jagostinho.scheduler_api.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jagostinho.scheduler_api.business.Task;
import com.jagostinho.scheduler_api.dal.TaskRepository;

@Configuration
public class TaskConfig {
    java.sql.Date date = new java.sql.Date(0);

    @Bean
    CommandLineRunner commandLineRunner(TaskRepository repository) {

        return args -> {
            Task task1 = new Task(
                    date,
                    date,
                    date,
                    date,
                    "task1",
                    "description1",
                    1,
                    true);

            Task task2 = new Task(
                    date,
                    date,
                    date,
                    date,
                    "task2",
                    "description2",
                    1,
                    true);

            repository.saveAll(List.of(task1, task2));
        };
    }
}
