package P1;

public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()) {
                    System.out.println("hello Thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        for (int i = 0; i < 100; i++) {
                            System.out.println("hello world");
                        }
                        break;
                    }
                }
            }
        });
        t.start();

        Thread.sleep(3000);
        t.interrupt();
    }
}
