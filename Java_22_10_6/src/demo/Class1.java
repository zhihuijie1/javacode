package demo;

public class Class1 {
    public int numWays(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int a = 1;
        int b = 2;
        int nub = 0;
        for(int i = 3; i <= n; i++){
            nub = a + b;
            a = b;
            b = nub;
        }
        return nub;
    }
}
