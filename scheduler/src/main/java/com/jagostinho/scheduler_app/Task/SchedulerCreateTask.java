package com.jagostinho.scheduler_app.Task;

import java.util.TimerTask;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jagostinho.scheduler_api.domain.Task;

public class SchedulerCreateTask extends TimerTask {

    private String url = "";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private Task task = null;

    public Task getTask() {
        return task;
    }

    public void setUrl(Task task) {
        this.task = task;
    }

    public SchedulerCreateTask(String url, Task task) {
        this.url = url;
        this.task = task;
    }

    @Override
    public void run() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Task> responseType = restTemplate.postForEntity(url, this.task, Task.class);
        System.out.println(responseType);
    }

}