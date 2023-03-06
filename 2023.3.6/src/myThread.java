public class myThread extends Thread{
    public myThread() {
        System.out.println("print this: " + this.getName());
        System.out.println("print thread.currentThread: " + Thread.currentThread().getName());
    }
    @Override
    public void run() {
        System.out.println("run this: " + this.getName());
        System.out.println("run currentThread: "+ Thread.currentThread().getName());
    }
}
