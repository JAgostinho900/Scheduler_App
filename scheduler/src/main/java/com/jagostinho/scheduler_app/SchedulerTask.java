package com.jagostinho.scheduler_app;

import java.util.TimerTask;

import org.springframework.web.client.RestTemplate;

import com.jagostinho.scheduler_api.domain.Task;

public class SchedulerTask extends TimerTask {

    // TODO: Tem de cumprir criterios SOLID

    @Override
    public void run() {
        String url = "http://localhost:8080/api/v1/task";
        RestTemplate restTemplate = new RestTemplate();
        Task[] listTasks = restTemplate.getForObject(url, Task[].class);
        System.out.println(listTasks);
    }

}