package com.jagostinho.scheduler_app;

public class SchedulerMain {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler(new SchedulerTask());
        scheduler.executeScheduler(200, 1500);
    }
}
