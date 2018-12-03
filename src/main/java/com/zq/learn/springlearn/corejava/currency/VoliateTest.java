package com.zq.learn.springlearn.corejava.currency;

import javax.jnlp.DownloadService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class VoliateTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(2);

        Counter counter = new Counter();

        new Thread(new CounterIncrement(counter, true, startSignal, doneSignal)).start();
        new Thread(new CounterIncrement(counter, false, startSignal, doneSignal)).start();

        startSignal.countDown();
        doneSignal.await();

        System.out.println(counter.num);
    }

    private static class CounterIncrement implements Runnable{

        private Counter counter;
        private boolean sleep;
        CountDownLatch startSignal = null;
        CountDownLatch doneSignal = null;

        public CounterIncrement(Counter counter,boolean sleep,CountDownLatch startSignal,
                                CountDownLatch doneSignal) {
            this.counter = counter;
            this.sleep = sleep;
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try {
                startSignal.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            int num = counter.num;
            System.out.println(Thread.currentThread().getName() + ":获取计数器的数量" + num);
            if (sleep) {
                System.out.println(Thread.currentThread().getName() + ":进入睡眠状态" + num);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            counter.num = counter.num + 1;
            System.out.println(Thread.currentThread().getName() + ":累加计数器" + counter.num);

            doneSignal.countDown();
        }
    }

    private static class Counter{
        private volatile int num;

        public int getNum() {
            return num;
        }
    }
}
