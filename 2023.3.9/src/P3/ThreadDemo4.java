package P3;

public class ThreadDemo4 {
    public static void main(String[] args) {
        // 规定lucker1 is 1, lucker2 is 2, form small to big
        Object lucker1 = new Object();
        Object lucker2 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lucker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lucker2){
                    System.out.println("获取到locker1 locker2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lucker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lucker2){
                    System.out.println("获取到locker2 locker1");
                }
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


    }
}
