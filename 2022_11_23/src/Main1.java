import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String[] result = string.split(" ") ; // 按照空格拆分
        for (int i = 0; i < result.length; i++) {
            if(i != result.length-1) {
                System.out.print(result[i]+" ");
            }else {
                System.out.println(result[i]);
            }
        }
    }
}