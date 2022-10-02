package demo2;

public class Test {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.pop();
        myQueue.push(5);
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();

    }
}
