package demo;

public class Test2{
    static int cnt = 6;
    static{
        cnt += 9;
    }

    public static void main(String[] args) {
        System.out.println(cnt);
    }
    static{
        cnt /=3;
    };
}