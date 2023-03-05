package review;

public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new myThread();
        t.start();
        Thread.sleep(3000);
        t.interrupt();
    }
}

class myThread extends Thread {
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
