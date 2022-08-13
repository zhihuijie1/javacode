package demo1;
//递归小训练
public class Test2 {
    //创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
    public static void main(String[] args) {
       int[] arr = {0};
       int i = 0;
       Test2 test2 = new Test2();
       test2.array(arr , i);
    }
    public void array(int[] arr,int i){

    }

    //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
    public static void main1(String[] args) {
        int n = 1234;
        Test2 test2 = new Test2();
        System.out.println(test2.func(n));
    }
    public int func(int n){
        if(n / 10 == 0){
            //System.out.print(n % 10+ " ");
            return n % 10;
        }else{
            func(n / 10);
            //System.out.print(n % 10+ " ");
            return n % 10 +func(n / 10);
        }
    }
}
