package ThreadPackage;

public class ThreadDemo1 extends Thread{
    @Override
    public void run() {
        while(true) {
            System.out.println("hello world");
        }
    }
}


class Main {
    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        threadDemo1.start();
        while(true) {
            System.out.println("hello");
        }
    }
}
