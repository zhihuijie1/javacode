package demo1;

public class Test2 {
    public static void main(String[] args) {
        Test test = new Test("George",21);
        Test2 test2 = new Test2();
        test2.shower(test);
    }

    public void shower(Test testo){
        testo.show();
    }

}
