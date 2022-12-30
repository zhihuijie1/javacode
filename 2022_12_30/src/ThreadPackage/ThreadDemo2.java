package ThreadPackage;

import static java.lang.Thread.sleep;

public class ThreadDemo2 implements Runnable {
    @Override
    public void run() {
        while(true) {
            System.out.println("hello world--------");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Main1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo2());
        thread.start();
    }
}
