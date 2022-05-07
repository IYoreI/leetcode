package com.yore;

import java.util.concurrent.*;

/**
 * @author Yore
 * @date 2022/3/8 9:27
 * @description
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ExecutorService executorService1 = new ThreadPoolExecutor(5,5,0L,
                TimeUnit.MICROSECONDS,new LinkedBlockingQueue<>(1024),threadFactory);
        Callable<String> c = new MyCallable("1");
        Future<String> f = executorService1.submit(c);
        String res = f.get();
        System.out.println(res);
        System.out.println("end");
        executorService.shutdown();
    }
}

class MyCallable implements Callable<String> {
    private String oid;

    public MyCallable(String oid) {
        this.oid = oid;
    }

    @Override
    public String call() throws Exception {
        return oid;
    }
}
