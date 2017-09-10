package com.javarush.task.Examples;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Ben on 2017-09-10.
 * Thanks to:
 * http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
 */
public class Executor {

    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };
        task.run();
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("Done simple concurrent!");

        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                Thread.sleep(1000);
                System.out.println("Bar " + name);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread2 = new Thread(runnable);
        thread2.start();
        System.out.println("Done with Foo...sleep(1000)...Bar!");

        //declare and start executor
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        //stop executor
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(3, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
        System.out.println("Done with Executor!");

        //This lambda expression defines a callable returning an integer after sleeping for one second:
        Callable<Integer> task3 = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
        ExecutorService executor2 = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor2.submit(task3);

        System.out.println("future done? " + future.isDone());
        Integer result = 0;
        try {
            //Calling the method get() blocks the current thread and waits until the callable completes
            result = future.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);

        //Executors support batch submitting of multiple callables at once via invokeAll().
        // This method accepts a collection of callables and returns a list of futures.
        ExecutorService executor3 = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");
        try {
            executor3.invokeAll(callables)
                    .stream()
                    .map(future2 -> {
                        try {
                            return future2.get();
                        } catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        //This example schedules a task with a fixed delay of one second between the end of an execution
        // and the start of the next execution. The initial delay is zero and the tasks duration is two seconds.
        // So we end up with an execution interval of 0s, 3s, 6s, 9s and so on.
        ScheduledExecutorService executor4 = Executors.newScheduledThreadPool(1);
        Runnable task4 = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            }
            catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };
        executor4.scheduleWithFixedDelay(task4, 0, 1, TimeUnit.SECONDS);
    }
}
