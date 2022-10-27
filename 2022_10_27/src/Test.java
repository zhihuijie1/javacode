import javafx.stage.Screen;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
class Student {
    public int age;
    public String name;
    public Student(String name ,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }


}
public class Test {
    /**
     * top k 问题
     * 找到前K个最小的
     */
    public int[] smallestK(int[] arr, int k) {
        int[] array = new int[k];
        if(k == 0) {
            return array;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(arr[i] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            array[i] = priorityQueue.poll();
        }
        return array;
    }


    public static void main(String[] args) {
        System.out.println(new Student("xiaobai",19).equals(new Student("xiaobai",19)));
    }
}
