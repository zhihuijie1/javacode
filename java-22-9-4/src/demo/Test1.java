package demo;

public class Test1 {
    int age = 10;
    String name = "hello";

    public static void func(){
        System.out.println("你好");
    }
}

class a extends Test1{
    void funcc(){
        Test1.func();
    }
}

class Test{
    public static void main(String[] args) {
        a A = new a();
        A.funcc();
    }
}