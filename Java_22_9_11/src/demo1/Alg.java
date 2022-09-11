package demo1;

public class Alg<T extends Comparable<T>> { //泛型上界  T必须是实现了Comparable接口的
    public T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max.compareTo(array[i]) < 0){
                max = array[i];
            }
        }
        return max;
    }


}





class Person implements Comparable<Person> {
    private int age;
    private String name;

    public Person(int age, String name){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}




class Test{
    public static void main(String[] args) {

        Integer[] array = {1,2,3,4,5,6};
        Alg<Integer> alg = new Alg<>();
        System.out.println(alg.findMax(array));


        Person[] person = {
                new Person(10,"xiaobai"),
                new Person(20,"xiaohong"),
                new Person(5,"xiaohuang"),
                new Person(30,"dabai")
        };

        Alg<Person> alg1 = new Alg<Person>();
        Person ret = alg1.findMax(person);
        System.out.println(ret);

    }
}
