package demo1;

public class Test implements Comparable<Test> {
    private int age;
    private String name;

    public Test(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Test o) {
        if(this.age > o.age){
            return 1;
        }else if(this.age < o.age){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Test{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
