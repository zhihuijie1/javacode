package demo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);//尾插
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(0,10);

        // 使用反向迭代器---反向遍历
        ListIterator<Integer> its = list.listIterator(list.size());
        while (its.hasPrevious()){
            System.out.print(its.previous()+" ");
        }
        System.out.println();
    }

    public static void main1(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(5);
        myLinkedList.addLast(5);
        myLinkedList.addLast(1);
        myLinkedList.addLast(5);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(5);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        myLinkedList.display();
        myLinkedList.removeAll(5);
        myLinkedList.display();
    }
}
