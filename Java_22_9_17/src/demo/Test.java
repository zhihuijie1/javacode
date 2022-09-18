package demo;

public class Test {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.display(linkedList);
        System.out.println(linkedList.size(linkedList));
        System.out.println(linkedList.contains(12));
        linkedList.addFirst(200);
        linkedList.display(linkedList);
        System.out.println(linkedList.size(linkedList));
        linkedList.addLast(100);
        linkedList.display(linkedList);
        System.out.println(linkedList.size(linkedList));
        linkedList.addIndex(2,1000);
        linkedList.display(linkedList);
        System.out.println(linkedList.size(linkedList));


    }
}
