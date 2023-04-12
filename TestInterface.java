package P1.package2;

public interface TestInterface {
    public static final int NUM= 10;
    public abstract void a();
    public default void b() {
        System.out.println("TestInterface-b()");
    }
}

class A implements TestInterface {
    @Override
    public void a() {
        System.out.println("A-a()");
        b();
        TestInterface.super.b();
    }

    public static void main(String[] args) {
        A a = new A();
        a.a();
    }
}
