package com.jagostinho.scheduler_api.scheduler;

import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {

    private Timer timer = null;

    private TimerTask timerTask;

    public TimerTask getTimerTask() {
        return timerTask;
    }

    public void setTimerTask(TimerTask timerTask) {
        this.timerTask = timerTask;
    }

    public Scheduler(TimerTask timerTask) {
        this.timer = new Timer();
        this.timerTask = timerTask;
    }

    public void executeScheduler(long delay, long interval) {
        timer.schedule(timerTask, delay, interval);
    }
}
