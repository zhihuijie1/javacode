import javax.swing.tree.TreeNode;
import java.util.List;
import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class LinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        //计算链表的长度
        int size = 0;
        ListNode cur = head;
        while(cur != null) {
            size++;
        }

        Stack<ListNode> stack = new Stack<>();
        if(size % 2 > 0) {
            int index = size / 2;
            while(index > 0) {
                index --;
                stack.push(head);
                head = head.next;
            }
            head = head.next;
            while(head != null) {
                if(head.val != stack.pop().val) {
                    return false;
                }
                head = head.next;
            }
            return true;
        }else {
           int index = size / 2;
           while(index > 0) {
               index --;
               stack.push(head);
               head = head.next;
           }
           while(head != null) {
               if(head.val != stack.pop().val) {
                   return false;
               }
               head = head.next;
           }
           return true;
        }

    }

    public boolean isPalindrome2(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        ListNode left = head;
        ListNode right = treverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    ListNode treverse2(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public boolean isPalindrome3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //找到slow 与 fast所指的节点
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转链表
        ListNode right = treverse(slow);
        ListNode left = head;

        while(left.next != right || left != right) {
            if(left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        if(left.val != right.val) {
            return false;
        }
        return true;

    }
    public ListNode treverse(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode cur = head.next;
        head.next = null;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        return head;
    }

}








