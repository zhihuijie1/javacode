package P1;

public class ThreadDemo3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("hello Thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"myThread");
        t.start();

        Thread.sleep(5000);
        System.out.println("join之前");
        t.join();
        System.out.println("join之后");

    }
}
