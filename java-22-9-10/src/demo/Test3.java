package demo;

import java.lang.reflect.Array;
import java.util.Arrays;

class Arrayer2<T>{
    //T[] array1 = new T[10];    error
    //T[] array = (T[]) new Object[10]; //注意这个地方有问题

    T[] array;

    public Arrayer2(Class<T> clazz,int capacity){
        array = (T[])Array.newInstance(clazz,capacity);
    }

    public void setArray(int pos, T value){
        array[pos] = value;
    }

    public T getArray(int pos){
        return array[pos];
    }

    public T[] getArray(){
        return array;
    }
}

public class Test3 {
    public static void main(String[] args) {
        Arrayer2<Integer> arrayer = new Arrayer2<Integer>(Integer.class,10);
        Arrayer2<String> arrayer2 = new Arrayer2<String>(String.class,10);


        arrayer.setArray(0,12);
        arrayer2.setArray(0,"nihao");
        arrayer2.setArray(1,"hhh");

        Integer[] ret = arrayer.getArray();

    }
}
