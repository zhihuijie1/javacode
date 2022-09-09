interface Shape 
{
    String name="ttt";  //public static final 常量
    void show();        //public abstract 方法
    default String getName()
    {
        return this.name;
    }
}


abstract  class Cycle implements  Shape
{
    public String name;
    public Cycle(String name){
        this.name = name;
    }
}

 class A extends Cycle
{
    public A(String name){
        super(name);
    }

    @Override
    public void show() 
    {
        System.out.println(getName() +"hhh");
    }
}


public class Test {
    public static void main(String[] args) 
    {
        Cycle shape1=new A("xiaobai") ;
        shape1.show() ;
    }

}
/*
结果：
ttthhh
*/