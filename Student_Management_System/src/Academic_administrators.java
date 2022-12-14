import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
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
                    System.out.println("请输入管理的次数");
                    int counts1 = scanner.nextInt();
                    HashSet<Integer> hashSet = new HashSet<>();
                    while(counts1 > 0) {
                        System.out.println("请输入学生ID");
                        int studentsID = scanner.nextInt();
                        // 输入学籍号
                        System.out.println("请输入学籍号");
                        int status = scanner.nextInt();
                        while (hashSet.contains(status)) {
                            System.out.println("学籍号已存在，请重新输入：");
                            status = scanner.nextInt();
                        }
                        hashSet.add(status);
                        jdbcInsertMYSQL.setStatus(studentsID,status);
                        System.out.println("录入成功");
                        counts1--;
                        System.out.println("管理次数还剩：" + counts1);
                    }
                    break;
                case 2:
                    jdbcInsertMYSQL.getCourse();
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
                    jdbcInsertMYSQL.getFullTable();
                    System.out.println("请输入你要修改的学生的ID");
                    int studentID = scanner.nextInt();
                    jdbcInsertMYSQL.getScoreTable(studentID);
                    System.out.println("请输入你要修改的次数：");
                    int count3 = scanner.nextInt();
                    while(count3 > 0) {
                        System.out.println("请输入课程ID：");
                        int courseID = scanner.nextInt();
                        System.out.println("请输入课程的分数：");
                        BigDecimal bigDecimal = scanner.nextBigDecimal();
                        jdbcInsertMYSQL.insertIntoScore(studentID,courseID,bigDecimal);
                    }
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
