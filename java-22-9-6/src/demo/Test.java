package demo;


abstract class Shape {
    private String name;

    public Shape(String name)
    {
        System.out.println("Shape构造方法");
        this.name=name;
        show();
    }

    abstract public void show();

    public String getName()
    {
        return this.name;
    }

}


abstract  class Cycle extends Shape {
    public Cycle  (String name,String sex)
    {
        super(name);
    }

}


class A extends Cycle {
    public A(String name,String sex)
    {
        super(name,sex);
    }

    @Override
    public void show() {
        System.out.println(getName() +"hhh");
    }
}

class B extends Shape{
    public B(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(getName() + "nihao");
    }
}

public class Test {
    public static void main(String[] args) {

        Shape shape=new A("小白","男");
        //shape.show() ;

        Shape shape1 = new B("小红");
    }

}

/*
输出结果：
Shape构造方法
小白hhh

*/


/*
如果把父类当中的show()方法打开的话
输出结果是：
Shape构造方法
小白hhh
小白hhh
*/
