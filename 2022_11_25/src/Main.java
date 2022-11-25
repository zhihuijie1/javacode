import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = new String(sc.next());
        String str2 = sc.next();
        int count = 0;
        for(int i = 0; i <= str1.length(); i++) {
            StringBuffer str = new StringBuffer(str1);
            if(i < str1.length()) {
                str.insert(i,str2);
            }else {
                str.append(str2);
            }
            if(func(str)) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static Boolean func(StringBuffer str) {
        int L = 0;
        int R = str.length()-1;
        while(L <= R) {
            if(str.charAt(L) != str.charAt(R)) {
                return false;
            }
            L++;
            R--;
        }
        return  true;
    }
}