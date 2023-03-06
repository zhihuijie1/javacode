package P3;

public class main {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 创建t对象，但是操作系统内核没有创建PCB，所以现在线程t的状态应该是NEW
        System.out.println(t.getState());

        t.start();

        for (int i = 0; i < 20000; i++) {
            System.out.println(t.getState());
        }

        t.join();
        // 现在PCB被销毁，但是t对象没有被销毁，所以现在线程t的状态应该是terminated
        System.out.println(t.getState());

    }
}
