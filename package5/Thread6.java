package P1.package5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Thread6 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                DateFormat dateFormat = new SimpleDateFormat("HH 点 mm 分 ss 秒");
                while(true) {
                    Date date = new Date();
                    System.out.println(dateFormat.format(date));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } , "Thread1");
        thread1.start();
    }
}
