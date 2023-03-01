class myThread extends Thread {
    @Override
    public void run() {
        System.out.println("hello world");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new myThread();
        t.start();
        /**
         *  start就是创建一个新的线程
         *  start -> 调用操作系统的API，操作系统的内核创建该线程的PCB，并将要执行的指令放进PCB中，让后将PCB放到CPU核心上执行，也就执行了run方法
         */
    }
}
