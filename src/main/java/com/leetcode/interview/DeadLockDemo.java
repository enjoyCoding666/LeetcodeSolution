package com.leetcode.interview;

public class DeadLockDemo {

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void main(String[] args) {
        deadLock();
    }

    public static void deadLock() {
        new Thread(()-> {
            synchronized (obj1) {
                System.out.println("持有对象1.");
                try {
                    //休眠，让各个线程都能拿到对象，再互相请求
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("持有对象1,获取对象2.");
                }
                System.out.println("持有对象1,成功获取对象2.");
            }
        }).start();

        new Thread(()-> {
            synchronized (obj2) {
                System.out.println("持有对象2.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("持有对象2,成功获取对象1.");
                }
                System.out.println("持有对象2,成功获取对象1.");
            }
        }).start();

    }
}
