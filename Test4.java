package P1.package2;

public class Test4 {
    // 属性
    private String name;
    private int age;
    private String sex;
    // 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) throws Exception {
        if(sex == "男" || sex == "女") {
            this.sex = sex;
        }else {
            // 制造运行时异常
            //throw new RuntimeException("性别不对！");
            // 制造检查异常
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 甩锅法
            throw new Exception();
        }
    }

    @Override
    public String toString() {
        return "Test4{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Test4() {
    }

    public Test4(String name, int age, String sex) throws Exception {
        this.name = name;
        this.age = age;
        /*
        try {
            this.setSex(sex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        this.setSex(sex);
    }

    //内部类
    static class text5 {
        public static void main(String[] args) throws Exception {
            Test4 t1 = new Test4();
            try {
                t1.setSex("sdasd");
            } catch (Exception e) {
                e.printStackTrace();
            }
            Test4 t2 = new Test4("asd",10,"sdas");
        }

    }

    public void eat() throws RuntimeException {
        System.out.println("父类的方法");
    }
}

class Test6 extends Test4 {
    @Override
    public void eat() throws Exception {
        super.eat();
    }
}


