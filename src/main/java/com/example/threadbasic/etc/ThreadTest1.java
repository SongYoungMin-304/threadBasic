package com.example.threadbasic.etc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest1 {

    private static final Logger logger = LoggerFactory.getLogger(ThreadTest1.class);

    public static void print(int a){

        try {
            int randomCnt = (int) (Math.random() * 3 + 1) * 1000;
            Thread.sleep(randomCnt);
            logger.info(String.valueOf(a));
        }catch (Exception e){

        }
    }

    public static class MyThread extends Thread {

        public int a;

        @Override
        public void run(){
            print(a);
        }
    }

    public static class MyRunnable implements Runnable {

        public int a;
        public MyRunnable(int a){
            this.a = a;
        }

        @Override
        public void run() {
            print(a);
        }
    }

    public static void main(String[] args) throws Exception{
        /*for(int a = 0; a < 100; a++){
            print(a);
        }*/

        // step1
        // 다중 스레드 사용
        // 100개의 스레드를 만들어서 처리

        for(int b = 0; b < 0; b++){
            /*int finalB = b;
            Thread t1 = new Thread(() -> print(finalB));
            t1.start();*/
            print(b);
        }
        // start 병행 처리 가능
        // run 병행 처리 불가능

        // step 1.1
        // thread extends 를 통한 처리
        for(int k = 0; k < 0; k++){
            MyThread t1 = new MyThread();
            t1.a = k;
            t1.start();
        }

        // step1.2
        // lmplements runnable 를 통한 처리
        for(int n = 0; n < 100; n++){
            Thread t1 = new Thread(new MyRunnable(n));
            t1.start();
        }


        // step2
        // 스레드의 갯수를 제한해서 사용해보자
        // 동시 스레드를 10개로 제한하고 돌리자
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int d = 0; d < 0; d++){
            int finalD = d;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    //logger.info(String.valueOf(finalD));
                    print(finalD);
                }
            });
        }
    }
}
