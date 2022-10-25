import java.util.Objects;

/**
 * 重写equals方法
 */
//内部类的这一部分再看一下
public class Test {


    static class Student {
        private String name;
        private int age;
        public Student(String name, int age) {
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
    public static void main(String[] args) {
        Student student1 = new Student("小白",19);
        Student student2 = new Student("小白",19);
        System.out.println(student1.equals(student2));
    }
}
