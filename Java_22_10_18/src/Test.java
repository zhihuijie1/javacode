public class Test {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {1,5,8,6,4,3,9,25,71,6};
        testHeap.initElem(array);
        testHeap.createHeap();
    }
}
