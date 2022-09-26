package demo;

public class MyLinkedList {

    static class LinkNode{
        public int val;
        public LinkNode prev;
        public LinkNode next;

        public LinkNode(int val){
            this.val = val;
        }
    }
    public LinkNode head;
    public LinkNode tail;

    /**
     * 头插法*/

    public void addFirst(int val){
        LinkNode node = new LinkNode(val);
        if(head == null){
            head = tail = node;
        }else{
            node.next = this.head;
            this.head.prev = node;
            node.prev = null;
            this.head = node;
        }
    }

    /**
     * 中间插*/
    public void  addIndex(int index, int data){
        LinkNode node = new LinkNode(data);
        LinkNode cur = findIndexListNode(index);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;


    }
    private LinkNode findIndexListNode(int index){
        LinkNode cur = this.head;
        while(index != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }
    //clear
    public void clear(){
        LinkNode cur = head;
        LinkNode curNext;
        while(cur != null){
            curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        head = null;
        tail = null;
    }
}
