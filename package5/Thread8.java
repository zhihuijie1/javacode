package P1.package5;

public class Thread8 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if(i == 6) {
                Thread.currentThread().stop();
            }
            System.out.println(i);
        }
    }
}
