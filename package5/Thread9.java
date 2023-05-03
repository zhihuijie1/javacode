package P1.package5;

public class Thread9 {
    public static void main(String[] args) {
        Windows w1 = new Windows("窗口1");
        Windows w2 = new Windows("窗口2");
        Windows w3 = new Windows("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}


class Windows extends Thread {
    // 属性
    public static int tickets = 2000; // 属于类，不属于任何的对象。

    // 构造器：
    public Windows(String name) {
        super(name);
    }

    // 方法：
    @Override
    public void run() {
        int i = 0;
        while (i <= 100) {
            synchronized (Windows.class) { // 必须是多个线程用同一把锁。
                if (this.tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "抢到了" + tickets-- + "票");
                }
            }
            i++;
        }
    }
}