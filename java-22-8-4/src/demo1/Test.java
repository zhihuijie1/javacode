package demo1;

public class Test {
    private String name;
    private int age;

    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show (){
        System.out.println(this.name+"的年龄是"+this.age+"岁");
    }

}
