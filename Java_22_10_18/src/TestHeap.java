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

}
















