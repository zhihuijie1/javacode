package P2;
class Counter {
    String name = "counter";
    synchronized public void print() {
        System.out.println(this.name);
    }

    synchronized public void add() {
        System.out.println(this.name + "你好");
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    counter.print();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    counter.add();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("结束");
    }
}
