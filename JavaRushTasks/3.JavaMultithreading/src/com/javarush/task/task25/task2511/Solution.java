package com.javarush.task.task25.task2511;

import java.util.Date;
import java.util.TimerTask;
import java.util.stream.IntStream;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                StringBuilder tMasked = new StringBuilder();
                IntStream.rangeClosed(1, t.getName().toString().length()).forEach(i -> tMasked.append("*"));
                String eMessage = e.getMessage();
                if (eMessage == null) eMessage = t.getName().toString() + " an Exception thrown!";
                String result = eMessage.replace(t.getName(), tMasked.toString());
                System.out.println(result);
            }
        };
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer task started at:"+new Date());
                try {
                    //assuming it takes 1 secs to complete the task
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Timer task finished at:"+new Date());
            }
        };
        Solution solution = new Solution(task);
        solution.handler.uncaughtException(Thread.currentThread(), new NumberFormatException());
    }
}