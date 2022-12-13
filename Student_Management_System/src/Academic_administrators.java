import java.sql.SQLException;
import java.util.Scanner;

// 教务管理人员
public class Academic_administrators {
    public void menu() throws SQLException {
        JDBCInsertMYSQL jdbcInsertMYSQL = new JDBCInsertMYSQL();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("请选择：  1：管理学生学籍信息    2 ：管理学生选课信息     3： 管理每学期课程考试成绩  4 : 退出");
            System.out.println("--------------------------------------------------------------------------");
            int value = scanner.nextInt();
            switch(value) {
                case 1:
                    jdbcInsertMYSQL.getStudent();
                    System.out.println("请输入学生ID");
                    int studentsID = scanner.nextInt();
                    // 输入学籍号
                    System.out.println("请输入学籍号");
                    int status = scanner.nextInt();
                    jdbcInsertMYSQL.setStatus(studentsID,status);
                    break;
                case 2:
                    jdbcInsertMYSQL.courses_table();
                    jdbcInsertMYSQL.getStudent();
                    System.out.println("请输入你要操作的次数");
                    int count = scanner.nextInt();
                    while(count > 0) {
                        jdbcInsertMYSQL.getStudent();
                        System.out.println("请选择一个同学的ID");
                        int studentID = scanner.nextInt();
                        jdbcInsertMYSQL.getCourse();
                        System.out.println("请选择一个课程的ID");
                        int courseID = scanner.nextInt();
                        jdbcInsertMYSQL.Insert_studentID_course_ID(studentID , courseID);
                        count--;
                    }
                    break;
                case 3:

                    break;
                case 4:
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
            if(value == 4) {
                break;
            }
        }
    }
}
