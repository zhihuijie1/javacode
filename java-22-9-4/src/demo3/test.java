package demo3;

import demo2.Animal;

public class test extends Animal {
    public test(){
        super("hh",10);
    }
    public void funcc(){
        test t = new test();
        System.out.println(t.name);
    }

}
