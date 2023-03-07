package P6;

public class DEMO {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        },"myThread");
        // 将t线程设置为后台线程
        t.setDaemon(true);
        t.start();
    }
}
