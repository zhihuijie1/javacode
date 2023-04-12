package P1.package2;
// 局部内部类
public class TestOuter2 {
    public void method() {
        final int num = 10;
        class A {
            public void a() {
                // 在局部内部类中被访问到的变量必须是被final修饰
                //num = 20;
                System.out.println(num);
            }
        }
    }

    // 如果类B在整个项目中只使用一次，那么就没有必要单独创建一个B类，使用内部类就可以了
    public Comparable method2() {
        class B implements Comparable {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        return new B();
    }
    // 匿名内部类
    public Comparable method3() {
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}
