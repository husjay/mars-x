package thread;

import java.util.concurrent.*;

/**
 * Created by sj.hu on 2019/4/3.
 */
public class CallableClass {

    public static void main(String[] args) throws Exception{

        CallableClass callableClass = new CallableClass();
        callableClass.testCallable();

    }

    public void testCallable() {

        ExecutorService service = Executors.newFixedThreadPool(1);
        MyCallable callable = new MyCallable();
        Future future = service.submit(callable);

        try {
            Object object = future.get(5, TimeUnit.SECONDS);
            System.out.println(object);
        } catch (ExecutionException e) {

        } catch (InterruptedException e) {

        } catch (TimeoutException e) {

        }

    }

    class MyCallable implements Callable<String> {

        public String call() throws Exception {

            System.out.println("running method call() and return Object");

            return "success";
        }
    }
}
