package java_concurrency.threads;
/*
 * Copyright (c) 2019-2023. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

/**
 *  Threads Creation - Part 1, Thread Capabilities & Debugging
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main1 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            //Code that will run in  a new thread
            System.out.println("we are now in thread "+Thread.currentThread().getName());
            System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(1000);
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority() + ", still running and sleeping");
                Thread.sleep(5000);
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority() + ", ended");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread.setName("New Worker Thread");

        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: " + Thread.currentThread().getName()+ " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName()+ " after starting a new thread");
    }
}
