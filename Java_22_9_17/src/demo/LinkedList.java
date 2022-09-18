package demo;

public class LinkedList {
    private List head;
    //创建节点并链接节点
    public LinkedList(){
        List list1 = new List(12);
        List list2 = new List(13);
        List list3 = new List(14);
        List list4 = new List(15);
        List list5 = new List(16);
        list1.setNext(list2);
        list2.setNext(list3);
        list3.setNext(list4);
        list4.setNext(list5);
        list5.setNext(null);
        this.head = list1;
    }

    //打印数据
    public void display(LinkedList linkedList){
        List cur = linkedList.head;
        while(cur != null){
            System.out.print(cur.getValue()+" ");
            cur = cur.getNext();
        }
        System.out.println();

    }
    //链表的长度
    public int size(LinkedList linkedList ){
        List cur = linkedList.head;
        int useSized = 0;
        while(cur != null){  //cur.getNext() != null-->空指针异常  head为null时
            useSized++;
            cur = cur.getNext();
        }
        return useSized;
    }

    //查找是否包含关键字key在单链表当中
    public boolean contains(int key){
        List cur = head;
        while(cur != null){
            if(cur.getValue() == key){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }
    //头插法
    public void addFirst(int data){
        List list = new List(data);
        list.setNext(head);//先连后面的，在将head的前移
        head = list;
    }
    //尾插法
    public void addLast(int data) {
        List list = new List(data);
        List cur = head;
        if (cur == null) {
            this.head = list;
        } else {
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            cur.setNext(list);
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex ( int index, int data){
        List list = new List(data);
        List cur = head;
        for (int i = 0; i < index - 1; i++) { //注意它走不回去
            cur = cur.getNext();
        }
        List cur2 = cur.getNext();
        cur.setNext(list);
        list.setNext(cur2);

    }




}
