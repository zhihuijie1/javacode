import java.util.*;
public class Main1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int v = 1;
        int sum = 0;
        while (M != 0) {
            while (M >= sum ) {
                v = v * N;
                sum = sum + v;
            }
            v = v / N;
            int i = 0;
            for (i = 0; i < N; i++) {
                if (i * v  > M) {
                    i--;
                    break;
                }else if(i * v  == M) {
                    break;
                }else if(i == N-1){
                    break;
                }
                
            }
            if (i < 10) {
                sb.append(i);
            } else {
                sb.append((char)(i+55));
            }
            M = M - i * v;
        }
        System.out.println(sb.toString());
    }
}