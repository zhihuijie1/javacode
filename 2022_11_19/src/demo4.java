public class demo4 {
    public static void find(int a) {
        int b = a & (~a+1);
        sout(b);
    }
    public static void sout(int b) {
        for(int i = 31; i >= 0; i--) {
            System.out.print((b & 1 << i) == 0 ? "0" : "1");
        }
    }

    public static void main(String[] args) {
        int a = 48;
        find(a);
    }
}
