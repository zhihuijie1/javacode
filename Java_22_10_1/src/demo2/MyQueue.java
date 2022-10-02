package demo2;

import java.util.Stack;

//使用两个栈实现先入先出队列  （自写）
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        Stack stack = stack1.isEmpty()? stack2 : stack1; //找非空栈
        stack.push(x);
    }
    
    public int pop() {
        if(this.empty()){
            return -1;
        }
        Stack<Integer> stack = stack1.isEmpty()? stack1 : stack2; //找空栈
        Stack<Integer> stack0 = stack1.isEmpty()? stack2 : stack1; //找非空栈
        int size = stack0.size();
        for (int i = 0; i < size - 1; i++) {
            stack.push(stack0.pop());
        }
        int ret = stack0.pop();
        stack0 = stack1.isEmpty()? stack2 : stack1; //找非空栈
        stack = stack1.isEmpty()? stack1 : stack2; //找空栈
        size = stack0.size();
        for (int i = 0; i < size; i++) {
            stack.push(stack0.pop());
        }
        return ret;
    }
    
    public int peek() {
        if(this.empty()){
            return -1;
        }
        Stack<Integer> stack0 = stack1.isEmpty()? stack2 : stack1; //找非空栈
        Stack<Integer> stack = stack1.isEmpty()? stack1 : stack2; //找空栈
        int size = stack0.size();
        int ret = -1;
        for (int i = 0; i < size; i++) {
            ret = stack0.pop();
            stack.push(ret);
        }
        stack0 = stack1.isEmpty()? stack2 : stack1; //找非空栈
        stack = stack1.isEmpty()? stack1 : stack2; //找空栈
        size = stack0.size();
        for (int i = 0; i < size; i++) {
            stack.push(stack0.pop());
        }
        return ret;
    }
    
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            return true;
        }
        return false;
    }

}