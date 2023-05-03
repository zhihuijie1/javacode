package P1.package5;

// 抢火车票
public class Thread2 {
    public static void main(String[] args) {
        window w1 = new window("窗口1");
        window w2 = new window("窗口2");
        window w3 = new window("窗口3");
        w1.start();
        w2.start();
        w3.start();

    }
}

// 窗口
class window extends Thread {
    // 构造器
    public window(String name) {
        super(name);
    }

    // 属性
    static int ticketnum = 10; // 共有的。

    // 方法
    @Override
    public void run() {
        while (ticketnum > 0) {
            System.out.println(this.getName() + "我抢到票了" + ticketnum--);
        }
    }
}

