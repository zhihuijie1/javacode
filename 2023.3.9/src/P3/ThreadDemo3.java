package P3;

public class ThreadDemo3 {
    public static int count = 0;

    synchronized public static void sum() {
        for (int i = 0; i < 5000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
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

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
