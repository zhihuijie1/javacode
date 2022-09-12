package demo2;

import java.util.Arrays;

public class SeqList {

    private int[] array;
    private int usedSize;
    public static final int SHUZI = 10;

    public SeqList(){
        array = new int[SHUZI];
    }

//打印顺序表
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.println(array[i]);
        }
    }


//新增元素,默认在数组最后新增
    /**
     * 1：数组是否为满 ，满了就扩容
     * 2：没满就放在尾部
     * 3：useSize++
     * */
    public void add(int data) {
        //1：数组是否为满 ，满了就扩容
        if(isFull()){
            array = Arrays.copyOf(array,array.length * 2);
        }
        //2：没满就放在尾部
        array[usedSize] = data;
        //3：useSize++
        usedSize++;
    }
    public boolean isFull(){
        if(this.usedSize == this.array.length){
            return true;
        }
        return false;
    }


//在 pos 位置新增元素
    /**
     * 注意执行顺序
     * 1 判断是否满了，满了就扩容
     * 2 判断pos位置是否合适 不合适就抛异常  注意不可以隔着元素添加
     * 3 然后在pos位置进行新增元素，后面的元素往后移
     * 4 usedSize++
     * */
    public void add(int pos, int data) {
        //1 判断是否满了，满了就扩容
        if(isFull()){
            array = Arrays.copyOf(array,array.length * 2);
        }
        //2 判断pos位置是否合适 不合适就抛异常  注意不可以隔着元素添加
        if(pos < 0 || pos > usedSize){
            System.out.println("pos位置不合法");
            throw new PosWrongfulException("pos位置不合法");
        }
        //3 然后在pos位置进行新增元素，后面的元素往后移
        for (int i = usedSize; i > pos ; i--) {
            this.array[i] = array[i-1];
        }
        array[pos] = data;
        //4 usedSize++
        usedSize++;
    }


//判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(array[i] == toFind){
                return true;
            }
        }
        return false;
    }


//查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if(array[i] == toFind){
                return i;
            }
        }
        return -1;
    }


 //获取 pos 位置的元素
    /**
     * 注意先判断顺序表是否为空
     * 1 顺序表是否为空  抛异常
     * 2 pos位置是否合理  抛异常
     * 3 获取pos位置的元素
     * */
    public int get(int pos) {
        //1 顺序表是否为空  抛异常
        if(isEmpty()){
            throw new EmptyException("当前顺序表为空！");
        }
        //2 pos位置是否合理  抛异常
        if(pos < 0 || pos > usedSize){
            System.out.println("pos位置不合法");
            throw new PosWrongfulException("pos位置不合法");
        }
        //3 获取pos位置的元素
        return array[pos];

    }

    public boolean isEmpty(){
        if(this.usedSize == 0){
            return true;
        }
        else return false;
    }


//给 pos 位置的元素设为 value
    /**
     * 1 顺序表是否为空  抛异常
     * 2 pos位置是否合理  抛异常
     * 3 pos 位置的元素设为 value
     * */
    public void set(int pos, int value) {
        //1 顺序表是否为空  抛异常
        if(isEmpty()){
            throw new EmptyException("当前顺序表为空！");
        }
        //2 pos位置是否合理  抛异常
        if(pos < 0 || pos > usedSize){
            System.out.println("pos位置不合法");
            throw new PosWrongfulException("pos位置不合法");
        }
        //3 pos 位置的元素设为 value
        this.array[pos] = value;
    }


//删除第一次出现的关键字key
    /**
     * 1 顺序表是否是空的  抛异常
     * 2 找的key元素所对应的下标
     * 3 删除个元素，后面的元素向前移
     * 4 usedSize--;
     * */

    public void remove(int toRemove) {
        //1 顺序表是否为空  抛异常
        if(isEmpty()){
            throw new EmptyException("当前顺序表为空！");
        }
        //2 找的key元素所对应的下标
        int ret = indexOf(toRemove);
        if(ret == -1){
            System.out.println("没有这个数字");
            return;
        }else{
            //3 删除个元素，后面的元素向前移
            for (int i = ret; i < usedSize-1; i++) {
                array[i] = array[i+1];
            }
            //4 usedSize--;
            this.usedSize--;
        }

    }


//获取顺序表长度
    public int size() {
        return this.usedSize;
    }


//清空顺序表
    public void clear() {
        this.usedSize =0;
    }
}



