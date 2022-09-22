package demo;

public class Test {
    /**
     * 合并两个有序链表
     * */
    public static MySingleList.ListNode mergeTwoLists(MySingleList.ListNode list1, MySingleList.ListNode list2) {
        MySingleList.ListNode node = new MySingleList.ListNode(10);
        MySingleList.ListNode cur1 = list1;
        MySingleList.ListNode cur2 = list2;
        MySingleList.ListNode cur3 = node;

        while(cur1.next != null && cur2.next != null){
            if(cur1.val < cur2.val){
                cur3.next = cur1;
                cur1 = cur1.next;
                cur3 = cur3.next;
            }else{
                cur3.next = cur2;
                cur2 = cur2.next;
                cur3 = cur3.next;
            }
        }
        if(cur1.next == null){
            cur3.next = cur2;
        }
        if(cur2.next == null){
            cur3.next = cur1;
        }
        return node.next;
    }

    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(1);
        mySingleList.addLast(3);
        mySingleList.addLast(5);
        MySingleList mySingleList2 = new MySingleList();
        mySingleList2.addLast(2);
        mySingleList2.addLast(4);
        mySingleList2.addLast(6);
        MySingleList.ListNode ret = mergeTwoLists(mySingleList.getHead(),mySingleList2.getHead());
        MySingleList mySingleList3 = new MySingleList();
        mySingleList3.setHead(ret);
        mySingleList3.display(ret);
    }
}
