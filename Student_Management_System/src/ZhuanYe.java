import java.util.ArrayList;

public class ZhuanYe {
    public ArrayList<ArrayList<Student>> subject = new ArrayList<>();
    public void create() {
        // 班级
        ArrayList<Student> class1 = new ArrayList<>();
        ArrayList<Student> class2 = new ArrayList<>();
        ArrayList<Student> class3 = new ArrayList<>();
        ArrayList<Student> class4 = new ArrayList<>();

        // 专业
        ArrayList<ArrayList<Student>> subject1 = new ArrayList<>();
        ArrayList<ArrayList<Student>> subject2 = new ArrayList<>();
        ArrayList<ArrayList<Student>> subject3 = new ArrayList<>();

        subject1.add(class1);
        subject1.add(class2);
        subject1.add(class3);
        subject1.add(class4);

        subject2.add(class1);
        subject2.add(class2);
        subject2.add(class3);
        subject2.add(class4);

        subject3.add(class1);
        subject3.add(class2);
        subject3.add(class3);
        subject3.add(class4);

    }
}
