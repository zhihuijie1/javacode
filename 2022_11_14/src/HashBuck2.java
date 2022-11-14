import java.rmi.UnexpectedException;

public class HashBuck2<K,V> {
    static class Node<K,V> {
        K key;
        V val;
        Node<K,V> next;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    int usedSize;
    //记载元素的个数
    Node<K,V>[] array;
    public HashBuck2() {
        array = new Node[8];
    }

    public void put(K key, V val) {
        //先将应用类型的数据转换成整形
        int hash = key.hashCode();
        //然后寻找它所对应的数组位置
        int index = hash % array.length;
        //遍历Index下标的数组，如果有相同的key那么替换
        Node cur = array[index];
        while(cur != null) {
            if(cur.key.equals(key)) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        //头插进去
        Node<K,V> node = new Node<>(key,val);
        node.next = array[index];
        array[index] = node;
        //usedSize加一
        usedSize++;
        //判断负载因子
        if(usedSize*1.0 / array.length >= 0.75) {
            //进行扩容
            Node<K,V>[] newArray = new Node[array.length * 2];
            //重新分配
            for (int i = 0; i < array.length; i++) {
                cur = array[i];
                while(cur != null) {
                    int newIndex = cur.key.hashCode() % newArray.length;
                    //头插进去
                    cur.next = newArray[newIndex];
                    newArray[newIndex] = cur;
                    cur = cur.next;
                }
            }
            array = newArray;
        }
    }
    public V get(K key) {
        int index = key.hashCode() / array.length;
        Node<K,V> cur = array[index];
        while(cur != null) {
            if(cur.key.equals(key)) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }
}
