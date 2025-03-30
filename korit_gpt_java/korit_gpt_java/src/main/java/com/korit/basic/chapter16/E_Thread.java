package com.korit.basic.chapter16;

public class E_Thread {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("first for : " + i);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println("second for : " + i);
//        }

//        1) Thread 1 생성, 시작
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("thread1 : " + i);

                try {
                    Thread.sleep(1000); //  1초동안 스레드를 일시 정지
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

//        2) Thread 2 생성, 시작
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("thread2 : " + i);

                try {
                    Thread.sleep(1000); //  1초동안 스레드를 일시 정지
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
    }
}
