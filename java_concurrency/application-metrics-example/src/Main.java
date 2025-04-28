/*
 * Copyright (c) 2019-2023. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

import java.util.Random;

/**
 * Atomic Operations, Volatile & Metrics practical example
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main {
    public static long COUTING_NUMBER = 10000000000L;
    public static void main(String[] args) {
        Metrics metrics = new Metrics();

        IncrementThread increamentThread = new IncrementThread(metrics);

        GetThread getThread = new GetThread(metrics);
        getThread.setDaemon(true);

        increamentThread.start();
        getThread.start();
        System.out.println("Starting counting...");
        try {
            increamentThread.join();
            long finalCount = metrics.getCount();
            System.out.println("Final count is: " + finalCount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class GetThread extends Thread {
        private Metrics metrics;

        public GetThread(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {
            long lastCount = 0;
            for (long i = 0; i < COUTING_NUMBER; i++) {
                long newCount = metrics.getCount();
                if (newCount < lastCount) {
                    System.out.println("Count is decreasing: " + newCount + " < lastCount: " + lastCount);
                    System.exit(1);
                } else {
                    System.out.println("Count is increasing: " + newCount);
                    lastCount = newCount;
                }
            }
        }
    }

    public static class IncrementThread extends Thread {
        private Metrics metrics;

        public IncrementThread(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {
            for (long i = 0; i < COUTING_NUMBER; i++) {
                metrics.increment();
            }
        }
    }

    public static class Metrics {
        private long count = 0;
//        private volatile double average = 0.0;

        public void increment() {
            count++;
        }

        public long getCount() {
            return count;
        }
    }
}
