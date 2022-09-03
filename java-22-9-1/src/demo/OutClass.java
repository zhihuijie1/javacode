package demo;

public class OutClass {
    public static int date = 1;
    String date2 = " 2 ";

    public int func(IntClass intClass){
        System.out.println(intClass.date6);
        return 1;

    }
    public int ret(){
        return 1;
    }
    public  static  void fun6(){
        int a = 10;

    }

    static class IntClass {
        int date = 10;

        public static final double date6 = 6.0;
        public void func3(OutClass outClass,IntClass intClass)
        {
            System.out.println(outClass.date2);
            System.out.println(outClass.func(intClass));
            func2();
        }
        public void func2(){
            System.out.println(date);
        }

    }

    public static void main(String[] args) {
        OutClass.IntClass intClass = new OutClass.IntClass();
        OutClass outClass = new OutClass();
        intClass.func3(outClass , intClass);
        outClass.func(intClass);
    }

}