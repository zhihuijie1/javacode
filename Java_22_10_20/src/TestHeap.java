import java.util.Arrays;

/**
 * 创建一个堆
 *
 */

public class TestHeap {
    public int[] elem;
    public int usedSize;

    public static final int DEFAULT_SIZE = 10;

    public TestHeap() {
        this.elem = new int[DEFAULT_SIZE];
    }

    public void initElem(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }

    public void createHeap() {
        /**
         * 找到所有的根节点，从下往上，对根节点的小树进行调整
         */
        for (int parent = (usedSize-1-1)/2; parent >= 0; parent--) {
            //找到所有的根节点
            //顺序是 自下而上
            shiftDown(parent,usedSize);
            //所有的根节点进行的调整
            //传参usedSize的原因 结束的条件
            //当一个树调整完成后可能会影响后面的树，要对后面的树再进行判断与调整，
            //找个条件让他停下来，就是usedSize，当child >= usedSize时就停下来
        }
    }

    private void shiftDown(int parent, int len) {
        int child = 2*parent+1;
        //堆中，根节点一定有左孩子，因为1：它是根 2：它是完全二叉树
        while(child < len) {
            if(child+1 < len && elem[child] < elem[child+1]) {
                // 如果有右孩子并且右孩子比左孩子大
                child++;
            }
            // 此时Child 指向左右孩子种最大的
            if(elem[child] > elem[parent]) {
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;
                parent = child;
                child = parent*2+1;
            }else {
                break;
            }
        }
    }

    /**
     * 自写
     * @param parent 根节点
     * @param usedSize 判断的范围
     */
    private void shiftDown2(int parent, int usedSize) {
        int child = parent*2+1;
        while(child < usedSize) {
            if(child+1 < usedSize) {
                child = elem[child] > elem[child+1]? child:child+1;
                if(elem[child] > elem[parent]) {
                    int temp = elem[child];
                    elem[child] = elem[parent];
                    elem[parent] = temp;
                    parent = child;
                    child = parent*2+1;
                }else {
                    break;
                }
            }else {
                if(elem[child] > elem[parent]) {
                    int temp = elem[child];
                    elem[child] = elem[parent];
                    elem[parent] = temp;
                    break;
                }else{
                    break;
                }

            }
        }
    }

    /**
     * 在堆中插入元素
     */
    public void offor (int val) {
        if(isFull()) {
            // 扩容
            elem = Arrays.copyOf(elem, elem.length*2);
        }
        elem[usedSize] = val;
        usedSize++;
        int child = usedSize-1;
        // 向上调整
        shiftUp(child);
    }

    // 向上调整
    public void shiftUp(int child) {
        int parent = (child-1)/2;
        while(child > 0) {
            if(elem[child] > elem[parent]) {
                // 交换
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public boolean isFull() {
        return this.usedSize == elem.length;
    }

    /**
     * 在堆中删除（弹出）元素
     */
    public void pop() {
        if(isEmpty()) {
            return;
        }
        // 交换
        int temp = elem[usedSize-1];
        elem[usedSize-1] = elem[0];
        elem[0] = temp;
        usedSize--;
        shiftDown3(0, usedSize);
    }

    //向下调整
    public void shiftDown3(int parent, int len) {
        int child = parent*2+1;
        while(child < len) {
            /*
            child指向的一定是最大的------>这个操作实现了复用if(elem[child] > elem[parent])这一部分
            右孩子比较特殊所以先判断右孩子， 如果有右孩子 && 右孩子比作孩子大 那 child++
            如果不满足以上条件，说明没有右孩子或者是右孩子比左孩子小 那child不动
            底下再判断一下 如果child > parent 那就交换 如果不是那就退出循环
             */
            if(child+1 < usedSize && elem[child+1] > elem[child]){
                child = child+1;
            }

            if(elem[child] > elem[parent]) {
                // 交换
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;

                parent = child;
                child = parent*2+1;
            }else {
                break;
            }
        }

    }
    public boolean isEmpty() {
        return usedSize == 0;
    }



}
















