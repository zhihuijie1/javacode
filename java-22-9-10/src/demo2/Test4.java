package demo2;

import java.lang.reflect.Array;

public class Test4<T> {
    T[] array;
    public Test4(Class<T> clazz,int capicity){
        array = (T[])Array.newInstance(clazz,capicity);
    }
}
