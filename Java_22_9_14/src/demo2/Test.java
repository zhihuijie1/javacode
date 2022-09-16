package demo2;

import java.util.ArrayList;

public class Test {

    public static ArrayList<Character> func(String str1 , String str2){
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if(!str2.contains(str1.charAt(i)+"")){
                arrayList.add(str1.charAt(i));
            }
        }
        return arrayList;
    }


    public static void main1(String[] args) {
        ArrayList<Character> arrayList = Test.func("welcome to bit", "come");
        System.out.println(arrayList);
    }


    public static void main(String[] args) {
        String str1 = "nihaohhhh";
        String str2 = "hhh";
        boolean t = str1.contains(str2);
        System.out.println(t);
    }
}
