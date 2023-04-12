package P1.package2;

import P1.package1.Test;

// 成员内部类
public class TestOuter {
    // 属性
    int age = 10;

    // 方法
    public void a() {
        System.out.println("这是a方法");
        {
            System.out.println("这是一个普通块");
            class B {

            }
        }
        class A {

        }
        // 外部类想要访问内部类的东西，需要创建内部类的对象然后进行调用
        // 注意访问的话，你要有实际的东西才能被访问
        D d = new D();
        System.out.println(d.name);
        d.method();
    }

    // 非静态成员内部类
    public class D {
        int age = 20;
        String name;

        public void method() {
            // 内部类可以访问外部类的内容
            System.out.println(age);
            a();
            int age = 30;
            System.out.println(age);// 30
            System.out.println(D.this.age);// 20
            System.out.println(TestOuter.this.age);// 10
        }

    }

    // 静态成员内部类
    static class E {
        public void method() {
            // 静态内部类只能访问外部类中被static修饰的东西(属性，方法)
            // System.out.println(age);
            // a();
        }
    }

    static {
        System.out.println("这是静态代码块");
    }

    {
        System.out.println("这是构造块");
    }
}

class Demo {
    public static void main(String[] args) {
        TestOuter testOuter = new TestOuter();
        testOuter.a();
        // 静态内部类对象的创建
        TestOuter.E e = new TestOuter.E();
        // 非静态内部类对象的创建
        // TestOuter.D d = new TestOuter.D(); wrong
        /*
          TestOuter t = new TestOuter();
          TestOuter.D d = t.new D();   // right
         */
        TestOuter.D x = new TestOuter().new D(); // right

    }
}
