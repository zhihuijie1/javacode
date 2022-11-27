public class HashBuck {

    static class Node {
        int key;
        int val;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int usedSize;
    Node[] array;
    public HashBuck() {
        array = new Node[8];
    }

    public void put(int key,int val) {
        int index = key % array.length;
        //先找到对应数组的下标
        //遍历Index下标的数组，如果有相同的key那么替换
        Node cur = array[index];
        while(cur != null) {
            if(cur.key == key) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        Node node = new Node(key, val);
        node.next = array[index];
        array[index] = node;
        //头插法
        usedSize++;
        //数组中元素的个数加一
        //判断一下负载因子
        if(usedSize * 1.0f / array.length >= 0.75f) {
            //进行扩容
            /**
             * 注意这里的扩容不是进行一个简单的拷贝，而是对原来数组中的每一个节点进行重新的分配
             */
            Node[] newArray = new Node[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                cur = array[i];
                while(cur != null) {
                    Node curNext = cur.next;
                    //先存一下cur的下一个节点
                    int newIndex = cur.key % newArray.length;
                    //找到对应的新数组的位置
                    cur.next = newArray[newIndex];
                    newArray[newIndex] = cur;
                    //头插
                    cur = curNext;
                }
            }
            array = newArray;
            //因为整体而言是对array进行操作的
        }
    }
    
    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while(cur != null) {
            if(cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
}