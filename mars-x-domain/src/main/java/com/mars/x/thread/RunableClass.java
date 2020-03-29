package com.mars.x.thread;

import java.util.concurrent.*;

/**
 * Created by sj.hu on 2019/4/3.
 */
public class RunableClass {

    public static void main(String[] args) throws Exception{

        RunableClass runableClass = new RunableClass();

        runableClass.testRunable();
        runableClass.testRunable2();

    }

    public void testRunable() {

        MyRunable runable = new MyRunable();
        Thread thread = new Thread(runable);
        thread.start();

    }

    public void testRunable2() {

        MyRunable runable = new MyRunable();
        ExecutorService service = Executors.newFixedThreadPool(1);
        //Future future = services.submit(runable);

        String result = "";
        Future future1 = service.submit(runable, result);

        try {
            //Object object = future.get(5, TimeUnit.SECONDS);
            //System.out.println(object);
            Object object = future1.get(5, TimeUnit.SECONDS);
            System.out.println(object);
        } catch (ExecutionException e) {

        } catch (InterruptedException e) {

        } catch (TimeoutException e) {

        }

    }


    class MyRunable implements Runnable {

        public void run() {
            System.out.println("running method run()...");
        }
    }
}
