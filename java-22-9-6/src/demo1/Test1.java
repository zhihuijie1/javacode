package demo1;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        Test[] student = new Test[]{
                new Test(60, "小红"),
                new Test(22, "小白"),
                new Test(33, "小青")
        };
        Arrays.sort(student);
        System.out.println(Arrays.toString(student));


    }
}
