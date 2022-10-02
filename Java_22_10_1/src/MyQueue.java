//队列
public class MyQueue {
    static class LinkList{
        int val;
        LinkList next;
        public LinkList(int val){
            this.val = val;
        }
    }
    public LinkList head;
    public LinkList tail;
    int usedSize = 0;

    public void offor(int val){
        usedSize++;
        LinkList list = new LinkList(val);
        if(head == null && tail == null){
            this.head = list;
            this.tail = list;
            return;
        }
        tail.next = list;
        tail = list;

    }

    public void display(){
        LinkList cur = head;
        while (cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public int poll(){
        if(head == null){
            throw new EmptyQueueExpection("空队列异常");
        }
        usedSize--;
        int ret = head.val;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return ret;
    }

    public int peek(){
        if(head == null){
            throw new EmptyQueueExpection("空队列异常");
        }
        return head.val;
    }

    public boolean IsEmpty(){
        return usedSize == 0;
    }

    public int getUsedSize(){
        return usedSize;
    }
}
