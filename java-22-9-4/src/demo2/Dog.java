package demo2;

public class Dog extends Animal{
    boolean silly;
    String name;
    public Dog(String name, int age, boolean silly){
        super(name , age);
        this.silly = silly;
    }

    public void func(){
        System.out.println(this.name+" "+this.age+" "+this.silly);
        System.out.println();
    }
}
