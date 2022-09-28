package demo;

public class Test {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        int x = stack.pop();
        System.out.println(x);
        x = stack.pop();
        System.out.println(x);
        x = stack.peek();
        System.out.println(x);

    }
}
