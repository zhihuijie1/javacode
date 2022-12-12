import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ZhuanYe zhuanYe = new ZhuanYe();
        zhuanYe.create();
        System.out.println("----------------------------------------------");
        System.out.println("请选择： 1：学生 2：教务管理人员 3：系统管理员");
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        System.out.println("----------------------------------------------");
        switch (val) {
            case 1:
                log();
                break;
            case 2:
                log();
                break;
            case 3:
                log();
                break;
            default:
                System.out.println("输入错误，请重新输入");
                break;
        }
    }

    // 登录方法
    public static Boolean log() {
        int count = 0;
        int password1 = 123456;
        java.util.Scanner scanner = new Scanner(System.in);
        while(count < 3) {
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
