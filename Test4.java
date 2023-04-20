package P1.package3;

import java.util.Arrays;
import java.util.Locale;

public class Test4 {
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "abcdef";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        str1.replace('a', 'u');


        String s1 = "abcdefg";
        String[] s2 = s1.split("-");
        int[] a = {1,2,3,45};
        System.out.println(Arrays.toString(s2));
        System.out.println(a);
        StringBuilder stringBuilder = new StringBuilder();

        System.out.println("-------------------------------");
        String z = new String("abcdef");
        char y = z.charAt(1);
        System.out.println(y);
        System.out.println("-------------------------------");
        String s = "abcdefghigklmnopqrst";
        System.out.println(s.substring(5));
        System.out.println(s.substring(3,8));
        System.out.println(s.concat("ppp"));

        String str = "a-b-c-d-e-f-g-h-i-k";
        String[] nub1 = str.split("-");
        System.out.println(Arrays.toString(nub1));
        String str3 = "    a c n u   ";
        String[] nub2 = str3.split(" ");
        System.out.println(Arrays.toString(nub2));
        String str4 = "abc cba mba obuuu";
        String[] nub3 = str4.split("b");
        System.out.println(Arrays.toString(nub3));
        System.out.println(str.toUpperCase());
        System.out.println(str3.toString());
        char[] arr = {98,99,100};
        System.out.println(String.valueOf(arr));
    }
}
