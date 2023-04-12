package P1.package3;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

// Calendar训练
public class Test2 {
    public static void main(String[] args) {
        System.out.println("请输入你想要查看的日期：（提示：请按照例如2012-5-6的格式书写）");
        Scanner scanner = new Scanner(System.in);
        // 输入字符串类型的日期
        String date = scanner.next();
        // 将String类型转换成Calendar类型
        // 分解法1：String -> Java.sql.Date  2: Java.sql.Date -> Calendar
        java.sql.Date sqdate = java.sql.Date.valueOf(date);
        Calendar cal = new GregorianCalendar();
        cal.setTime(sqdate);

        System.out.println("日"+"\t"+"一"+"\t"+"二"+"\t"+"三"+"\t"+"四"+"\t"+"五"+"\t"+"六");
        // 获取当月中的最大日期
        int maxDate = cal.getActualMaximum(Calendar.DATE);
        // 获取当月中的这一天
        int nowdate = cal.get(Calendar.DATE);
        // 把当月的这一天设置成当月的第一天
        cal.set(Calendar.DATE,1);
        // 获取当月第一天在周几
        int num = cal.get(Calendar.DAY_OF_WEEK);
        int count = 0;
        for (int i = 1; i < num; i++) {
            System.out.print("\t");
            count++;
        }
        for (int i = 1; i <= maxDate; i++) {
            if(i == nowdate) {
                System.out.print(i+ "*" + "\t");
            }else {
                System.out.print(i + "\t");
            }
            count++;
            if(count == 7) {
                System.out.println();
                count = 0;
            }
        }
    }
}
