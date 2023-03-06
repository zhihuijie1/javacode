package p1;

public class demo1 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("run this: " + this.getName());
                System.out.println("run currentThread: "+ Thread.currentThread().getName());
            }
        };
        t.start();
    }

}
