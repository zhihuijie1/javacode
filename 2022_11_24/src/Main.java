import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[4];
        for(int i = 0; i < 4; i++) {
            array[i] = sc.nextInt();
        }
        double a = (array[0] + array[2]) / 2.0;
        double b = (array[1] + array[3]) / 2.0;
        double c = b - array[1];
        if(a >= 0 && b >= 0 && c >= 0 && a-(int)a == 0 && b-(int)b == 0 && c-(int)c == 0) {
            System.out.print((int)a+" " + (int)b+" "+ (int)c);
        }else {
            System.out.print("NO");
        }
    }
}