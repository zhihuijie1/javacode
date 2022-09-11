package demo2;

import java.util.Arrays;

public class Alg2 {
    public <T extends Comparable<T>> void func(T[] array){
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i].compareTo(array[i+1]) < 0){
                T temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
    }

}

class Person implements Comparable<Person> {
    private String name;

    public Person(String name){
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.length() - o.name.length();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}


class Test1{
    public static void main(String[] args) {
        Person[] person = {
                new Person("xiaohong"),
                new Person("xiaohuang"),
                new Person("xiaohua")
        };
        Alg2 alg2 = new Alg2();
        alg2.func(person);
        System.out.println(Arrays.toString(person));

    }
}
