import java.sql.SQLException;
import java.util.Scanner;

// 学生
public class Student {
    //姓名
    private String name;
    //年龄
    private int age;
    // 学籍号
    private int status;
    // 成绩
    private float score;
    // 主修
    private String major_course;
    // 选修
    private String elective_course;
    public Student() {

    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    Scanner scanner = new Scanner(System.in);

    public void menu() throws SQLException {
        JDBCInsertMYSQL jdbcInsertMYSQL = new JDBCInsertMYSQL();
        while(true) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("请选择：  1： 注册入学    2 ：选择每学期学习的课程     3： 查询每学期课程考试成绩  4 : 退出");
            System.out.println("--------------------------------------------------------------------------");
            int value = scanner.nextInt();
            switch(value) {
                case 1:
                    System.out.println("请输入你的姓名：");
                    String name = scanner.next();
                    // 选择专业
                    jdbcInsertMYSQL.getZhuanYe();
                    System.out.println("请选择你的专业");
                    int zhuanYe = scanner.nextInt();
                    // 选择对应的班级
                    jdbcInsertMYSQL.get_classes_table();
                    System.out.println("请选择你的班级");
                    int classes = scanner.nextInt();
                    jdbcInsertMYSQL.admission(name , zhuanYe , classes);
                    jdbcInsertMYSQL.getStudent();
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
