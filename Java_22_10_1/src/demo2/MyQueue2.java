package demo2;

import java.util.Stack;
//使用两个栈实现先入先出队列  （学习）
class MyQueue2 {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue2() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(this.empty()){
            return -1;
        }
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()){
            return true;
        }
        return false;
    }
}