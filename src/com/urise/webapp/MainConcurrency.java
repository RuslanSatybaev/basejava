package com.urise.webapp;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainConcurrency {
    public static final int THREADS_NUMBER = 10_000;
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + ", " + getState());
            }
        };
        thread.start();
        new Thread(() -> System.out.println(Thread.currentThread().getName() +
                ", " + Thread.currentThread().getState())).start();
        System.out.println(thread.getState());

        final MainConcurrency mainConcurrency = new MainConcurrency();
        CountDownLatch latch = new CountDownLatch(THREADS_NUMBER);
        ExecutorService executorService = Executors.newCachedThreadPool();

//        List<Thread> threads = new ArrayList<>(THREADS_NUMBER);

        for (int i = 0; i < THREADS_NUMBER; i++) {
            executorService.submit(() ->
//          Thread thread1 = new Thread(() ->
            {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }
                latch.countDown();
                return 5;
            });
//            threads.add(thread1);
        }
/*
        threads.forEach(thread1 -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
*/
        latch.await();
        executorService.shutdown();
        System.out.println(counter);
    }

    private synchronized void inc() {
        counter++;
    }
}
