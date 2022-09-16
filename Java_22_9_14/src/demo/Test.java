package demo;

import java.util.*;

public class Test {

    public static ArrayList<Character> func (String str1,String str2){
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if(!str2.contains(str1.charAt(i)+"")){
                arrayList.add(str1.charAt(i));
            }
        }
        return arrayList;
    }
    public static void main(String[] args) {
        ArrayList<Character> arrayList = func("welcome to bit","come");
        System.out.println(arrayList);

    }

    public static void main6(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<>(3);
        arrayList.add(0,new Student("xiaobai",10,90));
        arrayList.add(1,new Student("xiaohong",20,80));
        arrayList.add(2,new Student("xiaogang",30,70));
        Collections.sort(arrayList);

        Iterator<Student> it = arrayList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }


    public static void main5(String[] args) {
        //打印arrayList当中的元素
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        //方法一：
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.println();
        //方法二：
        for (Integer x: arrayList) {
            System.out.print(x+" ");
        }
        System.out.println();
        //方法三
        Iterator<Integer> it = arrayList.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }

    public static void main4(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(5);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println(arrayList);
        System.out.println("----------------");
        //remove(int index); 删除下标为index的元素
        arrayList.remove(0);
        System.out.println(arrayList);
        System.out.println("----------------");
        //remove(object index); 删除index对象   里面要是对象/对象的引用
        arrayList.remove(new Integer(4));
        System.out.println(arrayList);

    }


    public static void main3(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(5);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(0,10);
        System.out.println(arrayList);
        System.out.println("------------------------");
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(9);
        arrayList1.add(8);
        System.out.println(arrayList1);
        arrayList1.addAll(arrayList);
        System.out.println(arrayList1);
        arrayList.clear();

    }


    public static void main2(String[] args) {
        ArrayList<Integer> arrayList0 = new ArrayList<>();
        arrayList0.add(1);
        arrayList0.add(2);
        arrayList0.add(3);
        System.out.println(arrayList0);
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("hello");
        arrayList1.add("xiaobai");
        System.out.println(arrayList1);
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>(linkedList);
        //ArrayList<Integer> arrayList3 = new ArrayList<>(arrayList1);
        System.out.println(arrayList2);
        //System.out.println(arrayList3);


    }


    public static void main1(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student("xiaobai",10,12.5));
        arrayList.add(new Student("xiaohong",20,18.5));
        arrayList.add(new Student("xiaohuang",30,19.5));
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
