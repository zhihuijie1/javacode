package demo;

public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.createList();
        mySingleList.addFirst(23);
        mySingleList.addFirst(23);
        mySingleList.addLast(23);
        mySingleList.addIndex(4,23);
        mySingleList.display();
        mySingleList.removeAll(23);
        mySingleList.display();
        MySingleList.ListNode ret = mySingleList.FindKthToTail(mySingleList.head,2);
        System.out.println(ret.value);
    }
}
