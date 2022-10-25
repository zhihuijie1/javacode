import java.util.PriorityQueue;

class KthLargest {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    //默认是小根堆

    int k ;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i:nums) {
            priorityQueue.offer(i);
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
    }
    
    public int add(int val) {
        priorityQueue.offer(val);
        if(priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}