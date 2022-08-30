package com.leetcode.other;


/**
 * 两个线程，交替打印奇偶数
 *
 * 参考资料： https://blog.csdn.net/Carson_Chu/article/details/109671975
 *
 */
public class TwoThreadNum {


    private static int count = 1;

    private static final Object OBJECT = new Object();

    public static void main(String[] args) {
        printTwo();
    }

    public static void printTwo() {

        Thread thread = new Thread(() -> {
            while (count % 2 == 1 && count < 100) {
                printfNum();
            }
        });
        thread.setName("thread-1");
        thread.start();


        Thread thread2 = new Thread(() -> {
            while (count % 2 == 0 && count < 100) {
                printfNum();
            }

        });
        thread2.setName("thread-2");
        thread2.start();

    }

    private static void printfNum() {
        //wait()和 notify，只能在 synchronized 里面使用。否则会报错： IllegalMonitorStateException
        synchronized (OBJECT) {
            try {
                //打印线程编号，以及奇偶数
                System.out.println(Thread.currentThread().getName() + ":" + count++);
                //唤醒其他线程
                OBJECT.notify();
                //休眠当前线程
                OBJECT.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
