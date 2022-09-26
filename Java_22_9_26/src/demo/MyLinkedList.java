package demo;

import java.util.List;

public class MyLinkedList {
    //LinkedList底层就是一个双向链表，我们来实现一个双向链表。
    static class LinkList{
        public LinkList prev;
        public LinkList next;
        public int val;

        public LinkList(int val){
            this.val = val;
        }
    }
    public LinkList head;
    public LinkList tail;
    /**
     头插法*/
    /*
    * 思路：
    * 新节点的next为head;
    * head的prev为新节点;
    * 新节点的prev为null
    * head指向新节点
    * 最后考虑一下特殊情况
    * */
    public void addFirst(int adta){
        LinkList node = new LinkList(adta);
        if(head == null){
            this.head = node;
            this.tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    /**
     * 尾插法*/
    /*
    * 思路：
    * tail的next是node
    * node的prev是tail
    * tail指向新节点
    * 考虑一下特殊情况
    * */
    public void addLast(int adta){
        LinkList node = new LinkList(adta);
        if(tail == null){
            this.head = node;
            this.tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }
    /**
     * 任意位置插入第一个数据节点是0*/
    /*
    * 思路：
    * 判断index是否合法（index不可以小于零，不可以隔着插）
    * 因为是双向链表，所以找到待查位置两节点的任意一个即可
    * 假设是前一个：就先别动前一个的next因为会找不到后面一个
    * 假设是后一个：就先别动后一个的prev因为会找不到前面一个
    * 要修改的值是前一个的next;后一个的prev；node的prev和 next
    * 考虑一下特殊情况
    * */
    public void addIndex(int index, int data){
        if(index < 0 || index > this.size()){
            throw new IndexException("下标范围异常");
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
            return;
        }
        LinkList node = new LinkList(data);
        LinkList cur = this.head;
        for (int i = 0; i < index-1; i++) {
            cur = cur.next;
        }
        node.prev = cur;
        node.next = cur.next;
        cur.next.prev = node;
        cur.next = node;
    }

    /*
    * 求链表的长度*/
    public int size(){
        LinkList cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * 查找是否包含关键字key是否在单链表当中*/

    /*
    * 遍历一下链表，有的话，就返回true
    * 判断一下特殊情况
    * */
    public boolean contains(int date){
        LinkList cur = this.head;
        while(cur != null){
            if(cur.val == date){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除第一次出现关键字为key的节点*/
    /**
     * 思路:
     * 找到你要删除的节点，
     * 前面节点的next指向后面的节点
     * 后面的节点的prev指向前面的节点
     * 考虑一下特殊情况
     *
     */
    public void remove(int key){
        if(this.head == null){
            return;
        }
        LinkList cur = this.head;
        while(cur != null){
            if(cur.val == key){
                //如果是第一个节点
                if(cur == head){
                   head = head.next;
                    //判断只有一个节点的情况
                   if(head == null){
                       tail = null;//tail不置为空。一直回收不了
                   }else {
                       head.prev = null;
                   }
                }else{
                    cur.prev.next = cur.next;//只要不是第一个节点都可以使用这条
                    if(cur.next != null){ //中间节点
                        cur.next.prev = cur.prev;
                    }else{ //尾节点
                        tail = cur.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }

    }

    /**
     * 删除所有值为key的节点
     * 学习
     */
    public void removeAll(int key){
        if(head == null){
            return;
        }
        LinkList cur = head;
        while (cur != null){
            if(cur.val == key){
                if(cur == head){
                    head = head.next;
                    if(head== null){
                        tail = null;
                    }else {
                        head.prev = null;
                    }

                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }else {
                        tail = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    /**
     * 删除所有值为key的节点
     * 自写 有些繁杂
     */
    public void removeAll1(int key){
        if(this.head == null){
            return;
        }

        LinkList cur = this.head;
        while (cur != null){
            if (cur.val == key){
                if(cur.prev == null && cur.next == null){
                    head = tail = null;
                }else if(cur.prev == null){
                    cur.next.prev = null;
                    head = head.next;

                }else if(cur.next == null){
                    cur.prev.next = null;
                    cur = cur.prev;
                    tail = cur;

                }else{
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }
    /**
     * 打印链表*/

    public void display(){
        LinkList cur = this.head;
        while (cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 链表置空*/
    public void clear(){
        LinkList cur = head;
        while (cur != null){
            LinkList temp = cur.next;
            cur.next = null;
            cur.prev = null;
            cur = temp;
        }
        head = null;
        tail = null;
        //最后这一步不要忘了
    }


}
