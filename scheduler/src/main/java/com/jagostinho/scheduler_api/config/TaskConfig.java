package com.jagostinho.scheduler_api.config;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jagostinho.scheduler_api.dal.TaskRepository;
import com.jagostinho.scheduler_api.domain.Task;

@Configuration
public class TaskConfig {
    LocalDateTime date1 = LocalDateTime.of(2022, 10, 26, 10, 0, 0);
    LocalDateTime date2 = LocalDateTime.of(2022, 10, 24, 10, 0, 0);
    LocalDateTime date3 = LocalDateTime.of(2022, 10, 25, 10, 0, 0);

    @Bean
    CommandLineRunner commandLineRunner(TaskRepository repository) {

        return args -> {
            Task task1 = new Task(
                    date1,
                    date1,
                    date1,
                    date1,
                    "task1",
                    "description1",
                    1,
                    true);

            Task task2 = new Task(
                    date2,
                    date2,
                    date2,
                    date2,
                    "task2",
                    "description2",
                    1,
                    true);

            Task task3 = new Task(
                    date3,
                    date3,
                    date3,
                    date3,
                    "task3",
                    "description3",
                    1,
                    true);

            if (repository.count() == 0) {
                repository.saveAll(List.of(task1, task2, task3));
            }
        };
    }
}
