import java.util.Arrays;

/**
 * 堆的模拟实现
 */
public class PriorityQueue {
    public int[] elem;
    public int usedSize;
    private static final int DEFAULT_SIZE = 11;
    public PriorityQueue() {
        this.elem = new int[DEFAULT_SIZE];
    }
 
    /**
     * 建堆的时间复杂度：
     *
     * @param array
     */
    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }
 
    /**
     *
     * @param root 是每棵子树的根节点的下标
     * @param len  是每棵子树调整结束的结束条件
     * 向下调整的时间复杂度：O(logn)
     */
    private void shiftDown(int root,int len) {
        int parent = root;
        int child = parent*2+1;
        while(child < len) {
            if(child+1<len && elem[child+1]>elem[parent]) {
                child = child+1;
            }
            if(elem[child] > elem[parent]) {
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = elem[child];
                parent = child;
                child = parent*2+1;
            }else{
                break;
            }
        }
    }
 
 
    /**
     * 入队：仍然要保持是大根堆
     * @param val
     */
    public void push(int val) {
        if(isFull()) {
            elem = Arrays.copyOf(elem,elem.length*2);
        }
        elem[usedSize] = val;
        usedSize++;
        shiftUp(usedSize-1);
    }
 
    private void shiftUp(int child) {
        int parent = (child-1)/2;
        while(parent > 0) {
            if(elem[child] > elem[parent]) {
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = elem[child];
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }
 
    public boolean isFull() {
        return usedSize == elem.length;
    }
 
    /**
     * 出队【删除】：每次删除的都是优先级高的元素
     * 仍然要保持是大根堆
     */
    public void pollHeap() {
        if(isEmpty()) {
            return;
        }
        int temp = elem[0];
        elem[0] = elem[usedSize-1];
        elem[usedSize-1] = temp;
        usedSize--;
        shiftDown(0,usedSize);
    }
 
    public boolean isEmpty() {
        return usedSize == 0;
    }
 
    /**
     * 获取堆顶元素
     * @return
     */
    public int peekHeap() {
        return elem[0];
    }
}