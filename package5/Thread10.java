package P1.package5;

public class Thread10 {
    public static void main(String[] args) {
        W w1 = new W("窗口1");
        W w2 = new W("窗口2");
        W w3 = new W("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}

class W extends Thread {
    // 属性
    public static int tickets = 20; // 属于类，不属于任何的对象。

    // 构造器：
    public W(String name) {
        super(name);
    }

    // 方法：
    @Override
    public void run() {
        int i = 0;
        while (i <= 100) {
            buyTickedt();
            i++;
        }
    }

    /*
    1：进来之前谁都别动 tickets ，进来之后再动 tickets 。
    2：保证是同一把锁。
     */
    synchronized public static void buyTickedt() {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "抢到了" + tickets-- + "票");
        }
    }
}