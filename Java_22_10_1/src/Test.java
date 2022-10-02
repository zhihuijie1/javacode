public class Test {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offor(1);
        myQueue.display();
        int ret = myQueue.poll();
        System.out.println(ret);
        myQueue.display();
        System.out.println(myQueue.usedSize);
    }
}
