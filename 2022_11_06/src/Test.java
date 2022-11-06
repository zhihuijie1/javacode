public class Test {
    // 合并两个排序的链表
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(10);
        ListNode cur = ret;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode cur3 = null;
        while(cur1 != null || cur2 != null) {
            if(cur1.val < cur2.val) {
                cur3 = cur1;
                cur.next = cur3;
                cur1 = cur1.next;
                cur3 = cur3.next;
            }else {
                cur3 = cur2;
                cur.next = cur3;
                cur2 = cur2.next;
                cur3 = cur3.next;
            }
        }
        while(cur1 != null) {
            cur3 = cur1;
            cur.next = cur3;
            cur3 = cur3.next;
            cur1 = cur1.next;
        }
        while(cur2 != null) {
            cur3 = cur2;
            cur.next = cur3;
            cur3 = cur3.next;
            cur2 = cur2.next;
        }
        return  ret;
    }
}
