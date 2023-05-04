package P1.package5;
// 死锁问题
/*
死锁问题的发生主要是两个或两个以上的线程出现了相互的依赖。
例如：线程A的后续执行所需要的对象，需要线程B释放锁才可以获取，而线程B的后续执行所需要的对象，需要线程A释放锁才可以获取。
所以两者之间产生了相互的阻塞。永远的阻塞。

主要的解决方法就是减少锁的嵌套使用。
 */
public class Thread12 {
    public static void main(String[] args) {
        // 有两个Object对象
        Object o1 = new Object();
        Object o2 = new Object();
        // 线程 t1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2) {
                        System.out.println("thread t1");
                    }
                }
            }
        }, "thread t1");

        // 线程 t2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1) {
                        System.out.println("thread t2");
                    }
                }
            }
        }, "thread t2");

        t1.start();
        t2.start();
    }
}
