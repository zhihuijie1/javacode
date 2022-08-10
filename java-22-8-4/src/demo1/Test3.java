package demo1;

public class Test3 {
    private String name = "smart";
    private int age = 12;

    public Test3() {
        this("xiaobai",21);
    }

    public Test3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setTest3(Test3 this, String name, int age){
        this.name = name;
        this.age = age;
    }
    public void show(Test3 this){
        System.out.println(this.name + " " + this.age);
    }
}
