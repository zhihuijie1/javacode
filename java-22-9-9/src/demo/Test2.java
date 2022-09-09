package demo;

class Arrayer{

    Object[] array = new Object[10];

    public void setArray(int pos, Object value){
        array[pos] = value;
    }

    public Object getArray(int pos){
        return array[pos];
    }
}

public class Test2 {
    public static void main(String[] args) {
       Arrayer arrayer = new Arrayer();
       arrayer.setArray(5,"hello");
       arrayer.setArray(4,20);

       //String str = arrayer.getArray(5); //error
        //getArray()方法返回的是Object 不会自动转化成String类型，要手动强转
        String str = (String) arrayer.getArray(5);//right
        System.out.println(str);
        System.out.println(arrayer.getArray(1));
    }
}


