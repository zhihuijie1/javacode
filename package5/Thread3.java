/*
package P1.package5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 1：可以不带泛型，如果不带泛型，那么call方法的返回值类型是Object类型。
// 2：如果带泛型，那么call对应的返回值类型就是泛型对应的类型
public class Thread3 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread3 thread3 = new Thread3();
        FutureTask ft = new FutureTask(thread3);
        Thread t = new Thread(ft);
        t.start();
        // 获取线程得到的返回值。
        Object obj = ft.get();
        System.out.println(obj);
    }
}

 */