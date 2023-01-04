package ThreadDemo;

public class demo1 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("hello");
                }
            }
        }, "myThread");
        t.start();
        /*
         t 是代码里的变量名，myThread是系统里的线程名，本质上myThread与t是t是指的同一个东西，一个东西可以有多个名字
         */
    }
}
