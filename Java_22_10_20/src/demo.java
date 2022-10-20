import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 学生类
 */
class student implements Comparable<student> {
    public String name;
    public int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(student o) {
        return o.age - this.age;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


class Comp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}



public class demo {
    public static void main(String[] args) {
        TestPriorityQueue();
    }
    public static void TestPriorityQueue() {
        PriorityQueue<student> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>(new Comp());
        PriorityQueue<Integer> q3 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>((x,y)->{return x.compareTo(y);});
        PriorityQueue<Integer> priorityQueue3 = new PriorityQueue<>((x,y)-> x.compareTo(y));

        q1.offer(new student("小白",10));
        q1.offer(new student("小红",20));
        q1.offer(new student("小黑",30));
        System.out.println(q1.peek());

        q2.offer(4);
        q2.offer(3);
        q2.offer(2);
        q2.offer(1);
        System.out.println(q2.peek());
    }
}
