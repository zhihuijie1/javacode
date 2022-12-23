package demo;

public class tese {

}

class A {
    public void func() {
        System.out.println("1");
    }
}

class B extends A {
    public static void main(String[] args) {
        B b = new B();
        b.func();
    }
}

