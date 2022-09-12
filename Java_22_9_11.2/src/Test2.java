public class Test2 {
    public static void main(String[] args) {
        Integer a = 10; //自动装箱
        Integer b = Integer.valueOf(20); //手动装箱
        System.out.println(a + b);

        int c = a.intValue();   //手动拆箱
        float d = a.floatValue(); //手动拆箱
        float e = a;  //自动拆箱
        System.out.println(c + " " + d + " " + e);
    }
}
