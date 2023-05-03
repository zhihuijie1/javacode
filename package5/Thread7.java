package P1.package5;

public class Thread7 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("thread ----- " + i);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        for (int i = 10; i < 20; i++) {
            System.out.println("main ----- " + i);
        }
    }
}
