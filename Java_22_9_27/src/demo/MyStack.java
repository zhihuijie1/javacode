package demo;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack {
    int[] elem;
    int usedSize = 0;

    public static int NUM = 10;

    public MyStack(){
        elem = new int[NUM];
    }
    /**
     * 压栈
     * */
    public int push(int val){
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[usedSize] = val;
        usedSize++;
        return val;
    }
    private boolean isFull(){
        if(this.usedSize == elem.length){
            return  true;
        }
        return false;
    }
    /**
     * 出栈
     */
    public int pop(){
        if(isEmpty()){
            throw new EmptyException("空栈异常");
        }
        int ret = this.elem[usedSize - 1];
        this.usedSize -- ;
        return ret;
    }
    private boolean isEmpty(){
        if(this.usedSize == 0){
            return true;
        }
        return false;
    }
    /**
     * 观察栈顶元素*/
    //主要是观察一下栈顶的元素，而非取出栈顶的元素
    public int peek() {
        if(this.isEmpty()){
            throw new EmptyException("空栈异常");
        }
        return this.elem[usedSize-1];
    }













}
