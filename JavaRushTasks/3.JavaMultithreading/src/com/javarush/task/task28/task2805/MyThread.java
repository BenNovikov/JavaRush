package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ben on 2017-09-28.
 */
public class MyThread extends Thread {
    private static AtomicInteger counter = new AtomicInteger(0);

    private void setMyPriority() {
        counter.set(counter.get() < 10 ? counter.incrementAndGet() : 1);
        setPriority(counter.get());
    }

    public MyThread() {
        setMyPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setMyPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setMyPriority();
    }

    public MyThread(String name) {
        super(name);
        setMyPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setMyPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setMyPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setMyPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setMyPriority();
    }
}
