package P1;

public class ThreadDemo {
    public static int count = 0;
    synchronized public static void sum() {
        for (int i = 0; i < 5_0000; i++) {
            count++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sum();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sum();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(end - begin);
    }
}
