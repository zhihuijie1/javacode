package ThreadPackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo3  {
    ExecutorService service = Executors.newCachedThreadPool();
    /**
     * service.execute(()->{
     *         System.out.println("hello___");
     *     });
     *     service.shutdown();
     */
}
