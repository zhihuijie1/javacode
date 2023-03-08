package P1;

public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("hello myThread");
            }
        },"myThread");
        t.start();

        t.join();
        System.out.println("hello main");
    }
}
