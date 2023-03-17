package P1;

public class Base {
    int a;
    int b;
    public void methodA() {
        System.out.println("hello baseA");
    }
    public void methodB() {
        System.out.println("hello baseB");
    }
}

class Derived extends Base {
    int a;
    char b;
    public void methodB() {
        System.out.println("hello methodb");
    }
    public void methodC() {
        a = 100;
        b = 20;
        super.a = 1000;
        super.b = 2000;
        methodB();
        super.methodA();
        super.methodB();
    }
}