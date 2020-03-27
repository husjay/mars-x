package com.mars.x.thread;

/**
 * Created by sj.hu on 2019/4/3.
 */
public class ThreadClass {

    public static void main(String[] args) throws Exception{

       ThreadClass threadClass = new ThreadClass();

        threadClass.testThread();


    }

    public void testThread() throws Exception{
        MyThread thread = new MyThread();

        thread.start();
    }

    public void threadMethod() throws Exception{
        MyThread thread = new MyThread();

        thread.start();

        thread.run();
        thread.start();
        thread.checkAccess();
        thread.interrupt();
        thread.join();
        thread.join(1L);
        thread.join(1L,1);
        thread.wait();
        thread.wait(1L);
        thread.wait(1L,1);
        thread.notify();
        thread.notifyAll();

        thread.setName("name");
        thread.setDaemon(true);
        thread.setContextClassLoader(new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        });
        thread.setPriority(1);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {

            }
        });

        thread.getId();
        thread.getName();
        thread.getPriority();
        thread.getState();
        thread.getStackTrace();
        thread.getThreadGroup();
        thread.getContextClassLoader();
        thread.getUncaughtExceptionHandler();
        thread.getClass();

        thread.isAlive();
        thread.isDaemon();
        thread.isInterrupted();
    }

    class MyThread extends Thread {

        @Override
        public void run() {

            int i=0;
            while(i++<10) {
                System.out.println("Running MyThread.run() " + i);
            }

        }

    }

}
