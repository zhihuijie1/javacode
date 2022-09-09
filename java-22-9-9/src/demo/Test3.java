package demo;

class Arrayer2<T>{

    T[] array = (T[]) new Object[10];

    public void setArray(int pos, T value){
        array[pos] = value;
    }

    public T getArray(int pos){
        return array[pos];
    }
}

public class Test3 {
    public static void main(String[] args) {
        Arrayer2<Integer> arrayer = new Arrayer2<Integer>();
        Arrayer2<String> arrayer2 = new Arrayer2<String>();

        int ret = arrayer.getArray(0);
        arrayer.setArray(0,12);
        arrayer2.setArray(0,"nihao");
        arrayer2.setArray(1,"hhh");



        System.out.println(arrayer.getArray(0));
        System.out.println(arrayer2.getArray(0));
        System.out.println(arrayer2.getArray(1));
    }
}

