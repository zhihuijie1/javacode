package P1.package5;

public class Thread4 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 200; i < 300; i++) {
                    System.out.println(i);
                }
            }
        } , "thread2");

        System.out.println(thread1.getPriority());// 5
        System.out.println(thread2.getPriority());// 5
        thread1.setPriority(7);
        thread2.setPriority(8); // 优先级别高一点，获取cpu资源的概率就大一点。
        thread1.start();
        thread2.start();
    }
}
