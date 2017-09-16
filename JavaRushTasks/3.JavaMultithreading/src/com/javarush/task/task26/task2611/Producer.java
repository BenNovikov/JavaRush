package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ben on 2017-09-16.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            int i = 1;
            while (true) {
                map.put(Integer.toString(i), "Some text for " + i);
                Thread.sleep(500);
                i++;
            }
        }
        catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " thread was terminated");
        }
    }
}
