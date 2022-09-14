package demo;

import java.util.Arrays;

public class MyArrayList {
    private int[] array;
    private int usedSize;
    public static final int DEFAULT_SIZE = 10;

    public MyArrayList(){
        array = new int[DEFAULT_SIZE];
    }//先开辟一块空间

//打印顺序表
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }

//新增元素,默认在数组最后新增
    /*
    * 1:判断数组是否满了  如果满了就扩容数组
    * 2:在数组后面新增一个元素
    * 3：usedSize++
    * */

    public void add(int data) {
        //1:判断数组是否满了
        if(this.isFull()){
            //如果满了就扩容数组
            array = Arrays.copyOf(array,2*array.length);
        }
        //2:在数组后面新增一个元素
        this.array[usedSize] = data;
        //3：usedSize++
        this.usedSize++;
    }
    public boolean isFull(){
        if(this.usedSize >= this.array.length){
            return true;
        }else{
            return false;
        }
    }

//在 pos 位置新增元素
    /*
    * 1:判断数组是否满了  如果满了就扩容
    * 2：判断pos位置是否合理(下标不可以是负数，不可以隔着放)  如何位置不合理就抛异常
    * 3：将pos后面的元素往后挪动
    * 4：在pos位置添加元素
    * 5：usedSize++
    * */
    public void add(int pos, int data) {
        //1:判断数组是否满了  如果满了就扩容
        if(this.isFull()){
            //如果满了就扩容数组
            array = Arrays.copyOf(array,2*array.length);
        }
        //2：判断pos位置是否合理  如何位置不合理就抛异常
        if(pos < 0 || pos > this.usedSize){
            System.out.println("pos位置不合理");
            throw new PosWrongfulException("pos位置不合理");
        }
        //3：将pos后面的元素往后挪动
        for (int i = this.usedSize; i > pos; i--) {
            this.array[i] = this.array[i-1];
        }
        //4：在pos位置添加元素
        this.array[pos] = data;
        //5：usedSize++
        this.usedSize++;
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
        for (int i = 0; i < this.usedSize; i++) {
            if(this.array[i] == toFind){
                return i;
            }
        }
        return -1;
    }

//获取 pos 位置的元素
    /*
    * 1 判断顺序表是否为空  抛出异常
    * 2 判断pos位置是否合法   不合法就抛出异常
    * 3 获取 pos 位置的元素
    * */

    public int get(int pos) {
        //1 判断顺序表是否为空  抛出异常
        if(this.isEmpty()){
            System.out.println("顺序表为空");
            throw new EmptyException("当前顺序表为空！");
        }
        //2 判断pos位置是否合法   不合法就抛出异常
        if(pos < 0 || pos > this.usedSize){
            System.out.println("pos位置不合理");
            throw new PosWrongfulException("pos位置不合理");
        }
        //3 获取 pos 位置的元素
        return this.array[pos];

    }
    public boolean isEmpty(){
        if(this.usedSize == 0){
            return true;
        }
        return false;
    }

//给 pos 位置的元素设为 value
    /*
    * 1 数组是否为空
    * 2 pos位置是否合法
    * 3 给 pos 位置的元素设为 value
    * */
    public void set(int pos, int value) {
        //1 数组是否为空
        if(this.isEmpty()){
            System.out.println("顺序表为空");
            throw new EmptyException("当前顺序表为空！");
        }
        //2 pos位置是否合法
        if(pos < 0 || pos >= this.usedSize){
            System.out.println("pos位置不合理");
            throw new PosWrongfulException("pos位置不合理");
        }
        //3 给 pos 位置的元素设为 value
        this.array[pos] = value;
    }

//删除第一次出现的关键字key
    /*
    * 1 判断顺序表是否为空
    * 2 删除第一次出现的关键字key
    * 3 usedSize--
    * */
    public void remove(int toRemove) {
        //1 判断顺序表是否为空
        if(this.isEmpty()){
            System.out.println("顺序表为空");
            throw new EmptyException("当前顺序表为空！");
        }
        //2 删除第一次出现的关键字key
        int ret = this.indexOf(toRemove);
        if(ret == -1){
            System.out.println("没有这个数字");
        }else{
            for (int i = ret; i < this.usedSize-1; i++) {
                this.array[i] = this.array[i+1];
            }
            //3 usedSize--
            this.usedSize--;
        }
    }
//获取顺序表长度
    public int size() {
        return this.usedSize;
    }
//清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}
