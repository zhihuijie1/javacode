package review;
public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new myRuannalbe());
        t.start();

        Thread.sleep(3000);
        System.out.println("hello main");
        t.interrupt();
    }
}

class myRuannalbe implements Runnable{
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            System.out.println("hello Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread结束");
                break;
            }
        }
    }
}
