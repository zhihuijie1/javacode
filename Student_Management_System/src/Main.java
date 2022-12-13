import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        JDBCInsertMYSQL jdbcInsertMYSQL1 = new JDBCInsertMYSQL();
        int count = 0;
        while(true) {
            if(count == 0) {
                jdbcInsertMYSQL1.create();
                jdbcInsertMYSQL1.courses_table();
                jdbcInsertMYSQL1.zhuanYe_table();
                jdbcInsertMYSQL1.classes_table();
                jdbcInsertMYSQL1.studentID_course_ID();
            }
            count++;
            System.out.println("----------------------------------------------");
            System.out.println("请选择： 1：学生 2：教务管理人员 3：系统管理员 4: 退出");
            Scanner scanner = new Scanner(System.in);
            int val = scanner.nextInt();
            System.out.println("----------------------------------------------");
            switch (val) {
                case 1:
                    log();
                    Student student = new Student();
                    student.menu();
                    break;
                case 2:
                    log();
                    Academic_administrators academic_administrators = new Academic_administrators();
                    academic_administrators.menu();
                    break;
                case 3:
                    log();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
            if(val == 4) {
                break;
            }
        }
    }

    // 登录方法
    public static Boolean log() {
        int count = 0;
        int password1 = 123456;
        java.util.Scanner scanner = new Scanner(System.in);
        while(count < 3) {
            System.out.println("请输入密码：");
            int password2 = scanner.nextInt();
            if(password1 == password2) {
                return true;
            }else {
                System.out.println("请重新输入");
                count++;
            }
        }
        System.out.println("密码错误");
        return false;
    }
}
