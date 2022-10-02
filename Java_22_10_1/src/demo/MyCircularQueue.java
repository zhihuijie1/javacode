package demo;

import java.util.Arrays;

//循环队列
class MyCircularQueue {
    private int[] elem;
    private int front; //下标
    private int rear;

    public MyCircularQueue(int k) {
        this.elem = new int[k];
    }
    //入栈
    /**
     * 思路：rear是队尾，去寻找要插入的空间，注意rear = (rear+1) % elem.length
     * 按这个公式去走才可以成环
     * 当栈满的时候就不可以再入栈了，而判断栈满的方法有2个：一个是用计数的方法，另一个是浪费一个空间
     * 当然你也可以扩容*/

    public boolean enQueue(int value) {
        //栈满
        if(this.isFull()){
            //扩容
            Arrays.copyOfRange(elem , rear ,rear + elem.length / 2);
        }
        elem[rear] = value;
        rear = (rear+1) % elem.length;
        return true;
    }


    //出栈
    public boolean deQueue() {
        if(this.isEmpty()){
            return false;
        }
        this.front = (front + 1) % elem.length;
        return true;
    }


    //瞄一眼首元素
    public int Front() {
        if(this.isEmpty()){
            return -1;
        }
        return elem[front];
    }
    
    public int Rear() {
        if(this.isEmpty()){
            return -1;
        }
        if(rear == 0){
            return elem[elem.length - 1];
        }
        return elem[rear - 1];
    }
    
    public boolean isEmpty() {
        if(rear == front){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if((rear+1) % elem.length == front){
            return true;
        }
        return false;
    }
}