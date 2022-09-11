package demo3;

import java.util.Arrays;

public class Alg3<T> {
    T[] array = (T[])new Object[10];

    public void setArray(int pos,T ret){
        array[pos] = ret;
    }

    public T getArray(int pos){
        return array[pos];
    }
    public T[] getArray(){
        return array;
    }
}

class Test{
    public static void main(String[] args) {
        Alg3<Integer> alg3 = new Alg3<>();
        alg3.setArray(0,12);
        int ret = alg3.getArray(0);
        System.out.println(ret);

        Integer[] arrat = alg3.getArray();
        System.out.println(Arrays.toString(arrat));
    }
}