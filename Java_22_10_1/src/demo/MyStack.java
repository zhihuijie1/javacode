package demo;
//使用两个队列实现一个后入先出（LIFO）的栈

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        Queue<Integer> queue = queue1.isEmpty() ? queue2 : queue1; // 不为空的队列
        queue.offer(x);
        return;
    }
    
    public int pop() {
        if(this.empty()){
            return -1;
        }
        /**
         * 注意：queue1.isEmpty()与queue1 == null的区别
         * queue == null，是判断这个引用是否指向了一块有效空间
         * isEmpty是已经有这块空间了，看这块空间里有没有放东西
         */
        Queue<Integer> queue = queue1.isEmpty() ? queue2 : queue1; // 不为空的队列
        Queue<Integer> queue0 = queue1.isEmpty() ? queue1 : queue2;//为空的队列
        /**
         * 注意:这个 queue.size() 刚上来一定要保存一份，因为随着 queue.poll() ，循环的条件
         * queue.size() - 1 会一直发生变化。
         */
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            int ret = queue.poll();
            queue0.offer(ret);
        }
        return queue.poll();
    }
    
    public int top() {
        if(this.empty()){
            return -1;
        }
        Queue<Integer> queue = queue1.isEmpty() ? queue2 : queue1; // 不为空的队列
        Queue<Integer> queue0 = queue1.isEmpty() ? queue1 : queue2;//为空的队列
        int size = queue.size();
        /**
         * 注意：这个地方是把所有的数据都移动到空的队列中
         * 用ret来记录一下，（倒到手）
         * 最后就知道最后的数据是多少了
         */
        int ret = -1;
        for (int i = 0; i < size; i++) {
            ret = queue.poll();
            queue0.offer(ret);
        }
        return ret;
    }
    
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()){ //即栈为空
            return true;
        }
        return false;
    }
}