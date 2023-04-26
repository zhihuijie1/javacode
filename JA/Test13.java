package P1.package4;

import java.io.*;

// 对象流
public class Test13 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Student student = new Student("asdas", 10, 198.1);
        //ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("A:\\TEXT\\122.txt")));
        //objectOutputStream.writeObject(student);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("A:\\TEXT\\122.txt")));
        //objectOutputStream.writeObject("niahsdasd");
        System.out.println(objectInputStream.readObject().toString());
        objectInputStream.close();
        //objectOutputStream.close();
    }
}

class Student implements Serializable {

    private static final long serialVersionUID = 7146497695527632385L;
    // 属性
    private String name;
    private int age;
    private double height;

    // 构造器
    public Student(String name, int age, double height) {
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
