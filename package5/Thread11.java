package P1.package5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread11 {
    public static void main(String[] args) {
        thread t = new thread();
        Thread thread1 = new Thread(t, "线程一");
        Thread thread2 = new Thread(t, "线程二");
        Thread thread3 = new Thread(t, "线程三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}


class thread implements Runnable {
    // 1：获取锁
    Lock lock = new ReentrantLock(); // 可重入锁

    static int i = 20000;

    @Override
    public void run() {
        // 2:加锁
        while (true) {
            lock.lock();
            try {
                if (i > 0) {
                    System.out.println(Thread.currentThread().getName() + i--);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 3:解锁
                lock.unlock();
            }
        }
    }
}