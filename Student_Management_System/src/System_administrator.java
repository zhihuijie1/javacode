import java.sql.SQLException;
import java.util.Scanner;

// 系统管理人员
public class System_administrator {
    public void menu() throws SQLException {
        JDBCInsertMYSQL jdbcInsertMYSQL = new JDBCInsertMYSQL();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("请选择：  1：管理课程    2 ：管理专业     3： 管理班级  4 : 退出");
            System.out.println("--------------------------------------------------------------------------");
            int value = scanner.nextInt();
            switch (value) {
                case 1:
                    jdbcInsertMYSQL.getCourse();
                    System.out.println("请输入课程的ID");
                    int course_ID = scanner.nextInt();
                    System.out.println("请输入课程的名称");
                    String course_name = scanner.next();
                    jdbcInsertMYSQL.insertIntoCOURSE(course_ID,course_name);
                    jdbcInsertMYSQL.getCourse();
                    break;
                case 2:
                    jdbcInsertMYSQL.getZhuanYe();
                    System.out.println("请输入专业的ID");
                    int zhuanYe_ID = scanner.nextInt();
                    System.out.println("请输入专业的名称");
                    String zhuanYes_ID = scanner.next();
                    jdbcInsertMYSQL.insertIntoZHUANYE(zhuanYe_ID,zhuanYes_ID);
                    jdbcInsertMYSQL.getZhuanYe();
                    break;
                case 3:
                    jdbcInsertMYSQL.get_classes_table();
                    System.out.println("请输入专业的ID");
                    int zhuanYeID = scanner.nextInt();
                    System.out.println("请输入班级ID");
                    int classesID = scanner.nextInt();
                    System.out.println("请输入班级名称");
                    String classesNAME = scanner.next();
                    jdbcInsertMYSQL.insertIntoCLASSES(zhuanYeID,classesID,classesNAME);
                    jdbcInsertMYSQL.get_classes_table();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("输入有误请重新输入：");
                    break;
            }
            if(value == 4) {
                break;
            }
        }
    }
}
