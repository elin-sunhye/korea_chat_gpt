package com.korit.main;

public class Main7 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i <  100; i++) {
                    try {
                        System.out.println("first for i : " + i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e); 프로그램이 강제 종료됨
                        System.out.println("프로그램 오류 발생 1");
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable1);
        t1.start();

        Runnable runnable2 = () -> {
            for(int i = 0; i <  100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
//                    throw new RuntimeException(e); 프로그램이 강제 종료됨
                    System.out.println("프로그램 오류 발생 2");
                }
                System.out.println("sec for i : " + i);
            }
        };

        Thread t2 = new Thread(runnable2);
        t2.start();

        for(int i = 0; i < 100; i++) {
            System.out.println("Main Thread i : " + i);
            Thread.sleep(1000);
        }
    }
}