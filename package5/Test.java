package P1.package5;

public class Test {
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");
        Thread1 thread1 = new Thread1("子线程");
        thread1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
