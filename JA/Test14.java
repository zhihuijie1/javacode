package P1.package4;

import java.io.*;

public class Test14 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("A:\\TEXT\\122.txt")));
        Person person = new Person("asfsdf" , 13 , 188.3);
        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        /*
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("A:\\TEXT\\122.txt")));
        System.out.println(objectInputStream.readObject());
        objectInputStream.close();
         */
    }
}

class Person {
    // 属性
    private String name;
    private int age;
    private double height;

    // 构造器
    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    // 方法
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}