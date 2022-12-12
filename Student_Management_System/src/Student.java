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

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    Scanner scanner = new Scanner(System.in);

    // 注册入学
    public void enrollment() {
        System.out.println("注册入学");
        System.out.println("请输入你的姓名");
        String name = scanner.nextLine();
        System.out.println("请输入你的年龄");
        int age = scanner.nextInt();
        Student student = new Student(name, age);

        System.out.println("请选择你的专业与班级");
        System.out.println("    1 : subject1    2 : subject2   3 : subject3    ");
        int a = scanner.nextInt();
        System.out.println("   1 : class1    2 : class2    3 : class3    4 : class4");
        int b = scanner.nextInt();
        switch(a) {
            case 1:
                switch(b) {
                    case 1:

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch(b) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                switch(b) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        break;
                }
                break;
        }
    }

}
