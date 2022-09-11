package demo2;


public class Alg {
    public static<T extends Comparable<T>> T findmax(T[] array){
        T max = null;
        for(int i = 0; i < array.length - 1; i++){
            if(array[i].compareTo(array[i+1]) < 0){
                max = array[i + 1];
            }
        }
        return max;
    }
}

class Test{
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        //Integer ret = Alg.findmax(array);
        Integer ret = Alg.<Integer>findmax(array);
        System.out.println(ret);
    }
}