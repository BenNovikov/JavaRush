package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            System.out.println(name);
            try {
                Thread.currentThread().sleep(100); //should use wait() but validator's going mad
            } catch (InterruptedException e) {
                break;
            } catch (IllegalMonitorStateException e) {
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {
        this.thread = new Thread(new TaskManipulator(), threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
