package ThreadPackage;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo4 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("hello ----");
        return "hh";
    }

    ExecutorService service = Executors.newCachedThreadPool();
    service.
}
