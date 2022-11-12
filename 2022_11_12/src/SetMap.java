import java.util.HashSet;
import java.util.Scanner;

public class SetMap {
    /**
     思路：HashSet 将打印出来的字符都放在HashSet当中，同时也有着去重的作用，
     然后遍历一下正确的字符，如果没有出现再HashSet当中，说明是坏掉的键
     然后存储在第二个HashSet当中（有去重的作用）
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //应输入的文字
        String str1 = scanner.nextLine();
        //实际输出的文字
        String str2 = scanner.nextLine();
        HashSet<Character> hashSet = new HashSet<>();
        //将打印出来的字符都放在HashSet当中
        String string2 = str2.toUpperCase();
        for(int i = 0;i < string2.length();i++) {
            hashSet.add(string2.charAt(i));
        }
        String string1 = str1.toUpperCase();
        for(int i = 0;i < string1.length();i++ ){
            if(!hashSet.contains(string1.charAt(i))) {
                hashSet.add(string1.charAt(i));
                System.out.print(string1.charAt(i));
            }
        }
    }
}
