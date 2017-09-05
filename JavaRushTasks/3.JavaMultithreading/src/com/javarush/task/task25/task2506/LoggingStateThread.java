package com.javarush.task.task25.task2506;

/**
 * Created by Ben on 2017-09-05.
 */
public class LoggingStateThread extends Thread {
    private Thread target;
    private State state;

    public LoggingStateThread(Thread target) {
        this.target = target;
        state = State.NEW;

    }

    @Override
    public void run() {

        System.out.println(State.NEW);
        do {
            if (target.getState() != state) {
                state = target.getState();
                System.out.println(state);
            }
        } while (state != State.TERMINATED);
    }
}
