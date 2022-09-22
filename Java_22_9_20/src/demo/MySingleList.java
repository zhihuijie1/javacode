package demo;

public class MySingleList {


    /**
     * 节点内部类
     */
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 每一个链表都有一个head
     */
    private ListNode head; //不初始化就默认为 null

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    /**
     * 临时创建一个链表
     */
    public void createList() {
        ListNode listNode1 = new ListNode(10);
        ListNode listNode2 = new ListNode(11);
        ListNode listNode3 = new ListNode(12);
        ListNode listNode4 = new ListNode(13);
        ListNode listNode5 = new ListNode(14);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        this.head = listNode1;
    }

    /**
     * 打印链表里面的数据，默认从头开始打印
     */
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 从指定节点newHead开始打印链表
     *
     * @param newHead
     */
    public void display(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //得到单链表的长度
    public int size() {
        int count = 0;
        ListNode cur = this.head;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
        }
        return false;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if (cur == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        } //注意if....else....

    }


    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        if (index < 0 || index > this.size()) {
            throw new IndexWrongFulException("index位置不合法");
        }
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if (index == 0) {
            this.addFirst(data);
        } else if (index == this.size()) {
            this.addLast(data);
        } else {
            int count = index - 1;
            while (count != 0) {  //cur向后移动容易，往前移动是不可能。 找到要插位置的前驱
                cur = cur.next;
                count--;
            }
            node.next = cur.next;
            cur.next = node;
        }

    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {

        if (this.head == null) {
            return;
        }
        if (this.head.val == key) {
            this.head = head.next;
            return;
        }
        ListNode ret = this.findPrevOfKey(key);
        if (ret == null) {
            System.out.println("没找到");
            return;
        }
        ret.next = ret.next.next;
    }

    private ListNode findPrevOfKey(int key) {
        ListNode cur = this.head;
        while (cur.next != null) {  //遍历链表只能从前往后遍历，不可能从后往前遍历。
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        while (this.head.val == key) {
            this.head = this.head.next;
            if (this.head == null) {
                return;
            }
        }
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }

    }

    //链表的置空
    public void clear() {
        this.head = null;
    }

    /**
     * 反转链表
     * */
    public ListNode reverseList() {

        //没有节点的时候
        if (this.head == null) {
            return null;
        }

        ListNode cur = this.head.next;  //
        this.head.next = null;  //

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = this.head;
            this.head = cur;
            cur = temp;  //
        }
        return this.head;
    }

    public ListNode middleNode() {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 寻找倒数第K个元素
     * */
    public ListNode FindKthToTail(ListNode head, int k) {
        if(k < 0){
            return null;
        }
        if(head == null){
            return null;
        }
        ListNode cur1 = head;
        ListNode cur2 = head;
        while (k-1 != 0) {
            cur1 = cur1.next;
            if(cur1 == null){
                return null;
            }
            k--;
        }
        while (cur1.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur2;
    }

    /***
     *
     * 环形链表二
     */
    public ListNode detectCycle(){
        ListNode fast = head;
        ListNode slow = head;
        //如果是环形的链表
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //找相遇点
            if(fast == slow){
                ListNode ptr = head;
                while(ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }





}
