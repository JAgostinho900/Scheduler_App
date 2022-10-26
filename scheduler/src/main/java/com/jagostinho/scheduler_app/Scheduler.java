package com.jagostinho.scheduler_app;

import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {

    public Scheduler() {

    }

    // TODO: Tem de cumprir criterios SOLID

    public void executeScheduler() {
        Timer timer = new Timer();
        TimerTask task = new SchedulerTask();
        timer.schedule(task, 200, 5000);
    }
}
