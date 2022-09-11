package demo4;
//通配符

public class Messager<T> {
    private T ret;

    public void setRet(T ret){
        this.ret = ret;
    }
    public T getRet(){
        return  this.ret;
    }
}

class test{
    public static void main(String[] args) {
        Messager<Integer> messager = new Messager<>();
        messager.setRet(10);
        func(messager);
        Messager<String> messager2 = new Messager<>();
        messager2.setRet("xiaobai");
        func(messager2);
    }
    public static void func(Messager<?> messager){
        System.out.println(messager.getRet());
    }

}