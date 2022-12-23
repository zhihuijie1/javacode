public class MyLinkedList<V> {
    static class ListNode<V> {
        public V val;
        public ListNode<V> prev;
        public ListNode<V> next;
        public ListNode(V val) {
            this.val = val;
        }
    }
    private ListNode<V> head;
    private ListNode<V> last;
    /**
     * 头插
     */
    public void addFirst(V key) {
        ListNode<V> node = new ListNode<>(key);
        if(head == null) {
            head = node;
            last = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }
    /**
     * 尾插
     */
    public void addLast(V key) {
        ListNode<V> node = new ListNode<>(key);
        if(head == null) {
            head = node;
            last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }
    /**
     * 在 index 位置插入
     */
    public void addIndex(int index, V key) {
        if(index < 0 || index > size()) {
            throw new RuntimeException("插入位置非法");
        }
        if(index == 0) {
            addFirst(key);
        } else if(index == size()) {
            addLast(key);
        } else {
            ListNode<V> node = new ListNode<>(key);
            ListNode<V> cur = head;
            while(index-- > 0) {
                cur = cur.next;
            }
            node.next = cur;
            node.prev = cur.prev;
            cur.prev.next = node;
            cur.prev = node;
        }
    }
    /**
     * 查找节点 key 是否在链表中
     */
    public boolean contains(V key) {
        ListNode<V> cur = head;
        while(cur != null) {
            if(cur.val.equals(key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除第一次出现的 key 节点
     */
    public void removeOne(V key) {
        if(head == null) {
            throw new RuntimeException("链表为空，无法进行删除");
        }
        ListNode<V> cur = head;
        while(cur != null) {
            if(cur.val == key) {
                if(cur == head) { // 头节点
                    head = head.next;
                    if(head != null) {
                        head.prev = null;
                    }
                } else { // 非头节点
                    cur.prev.next = cur.next;
                    if(cur != last) { // 非尾节点
                        cur.next.prev = cur.prev;
                    } else { // 尾节点
                        last = last.prev;
                    }
                }
                return;
            } else {
                cur = cur.next;
            }
        }
        System.out.println("要删除的节点不存在");
    }
    /**
     * 删除所有值为 key 的节点
     */
    public void removeAll(V key) {
        if(head == null) {
            throw new RuntimeException("链表为空，无法进行删除");
        }
        ListNode<V> cur = head;
        while(cur != null) {
            if(cur.val == key) {
                if(cur == head) { // 头节点
                    head = head.next;
                    if(head != null) {
                        head.prev = null;
                    }
                } else { // 非头节点
                    cur.prev.next = cur.next;
                    if(cur != last) { // 非尾节点
                        cur.next.prev = cur.next;
                    } else {
                        last = last.prev;
                    }
                }
                // 删完一个，找下一个
                cur = cur.next;
            } else {
                cur = cur.next;
            }
        }
    }
    /**
     * 获取 index 下标的元素
     */
    public V get(int index) {
        if(head == null) {
            throw new RuntimeException("链表为空");
        }
        ListNode<V> cur = head;
        while(index-- > 0) {
            cur = cur.next;
        }
        return cur.val;
    }
    /**
     * 将 index 位置的元素设为 key
     */
    public void set(int index, V key) {
        if(head == null) {
            throw new RuntimeException("链表为空");
        }
        ListNode<V> cur = head;
        while(index-- > 0) {
            cur = cur.next;
        }
        cur.val = key;
    }
    /**
     * 返回链表中第一个 key 所在下标
     */
    public int indexOf(V key) {
        if(head == null) {
            throw new RuntimeException("链表为空");
        }
        ListNode<V> cur = head;
        int index = 0;
        while(cur != null) {
            if(cur.val.equals(key)) {
                return index;
            }
            index++;
            cur = cur.next;
        }
        return -1;
    }
    /**
     * 返回链表的长度
     */
    public int size() {
        int count = 0;
        ListNode<V> cur = head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    /**
     * 清空链表
     */
    public void clear() {
        ListNode<V> cur = head;
        while(cur != null) {
            cur.val = null;
            ListNode<V> curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        head = null;
        last = null;
    }
}
