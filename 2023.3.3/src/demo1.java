

public class demo1 {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            while(!Thread.currentThread().isInterrupted()) {
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Thread线程中断");
                    break;
                }
            }
        });
        t.start();

        Thread.sleep(4000);
        System.out.println("hello main");
        t.interrupt();
    }
}
