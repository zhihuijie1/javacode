package P1.package2;

public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //检查异常：
        Class.forName("Test").newInstance();
    }
}
