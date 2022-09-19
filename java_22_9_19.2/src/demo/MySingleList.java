package demo;

public class MySingleList {

    //节点内部类
    static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
    //head
    public ListNode head;


//1、无头单向非循环链表实现
    public class SingleLinkedList {

    }

    public void createList(){
        //创建几个节点
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        //链接这些节点
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        this.head = listNode1;
    }



//头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;
    }

//尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(cur == null){
            this.head = node;
        }else{
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

//任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        ListNode node = new ListNode(data);
        ListNode cur = head;
        if(index < 0|| index > this.size()){
            System.out.println("index不合法");
            throw new IndexWrongFulException("index位置不合法");
        }else if(index == 0){
            addFirst(data);
        }else if(index == this.size()){
            addLast(data);
        }else {
            for (int i = 0; i < index-1; i++) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
    }

//查找是否包含关键字key在单链表当中
    public boolean contains(int key){
        ListNode cur = head;
        while (cur != null){
            if(cur.value == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
//删除第一次出现关键字为key的节点
    public void remove(int key){
        /**
         * ListNode cur = head;
         *         while (cur != null){
         *             if(cur.next.value == key){
         *                 //存在问题 到最后一个时 cur不为null 但cur.next == null  空指针异常
         *                 cur.next = cur.next.next;
         *             }
         *         }
         *         return;*/
        //链表为空的时候
        if(head == null){
            return;
        }
        //链表的头节点为key时
        if(head.value == key){
            head = head.next;
        }
        ListNode cur = head;
        while (cur.next != null){
            if(cur.next.value == key){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return;

    }
//删除所有值为key的节点
    public void removeAllKey(int key){}
//得到单链表的长度
    public int size(){
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
//打印链表中的数据
    public void display(){
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.value+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //删除节点中所有的值为key的值

    public void removeAll(int key){
        if(this.head == null){
            return;
        }
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while(head.value == key){
            head = head.next;
        }
        while (cur != null){
            if (cur.value == key){
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        /*
        * if(head.value == key){
            head = head.next;
        }
        * */
    }


    public void clear(){
        this.head = null;
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if(k > size() || k <= 0 || head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int ret = k-1;
        while(ret != 0){
            fast = fast.next;
            ret--;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}