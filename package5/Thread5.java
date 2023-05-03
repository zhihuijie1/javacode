package P1.package5;

public class Thread5 {
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Thread.currentThread().setName("thread1");
                for (int i = 0; i < 100; i++) {
                    if (i == 10) {
                        Thread thread2 = new Thread() {
                            @Override
                            public void run() {
                                Thread.currentThread().setName("thread2");
                                for (int j = 1000; j < 1200; j++) {
                                    System.out.println(Thread.currentThread().getName() + "-----" + j);
                                }
                            }
                        };
                        thread2.start(); // thread2执行完成之后再执行thread1
                        try {
                            thread2.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "-----" + i);
                }
            }
        };
        thread1.start();
    }
}
